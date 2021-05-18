package com.mxf.course.websocket;

/**
 * 通过websocket来实现交互
 * 设备userName 为设备id 用户UserName 为 openId
 * Create By  Baimao
 * Time:2019-09-11 10:39
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/api/v1/webSocket/{machineId}/{userName}")
@Component
public class WebSocketService {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketService.class);

    /**
     *      使用map来收集session，key为roomName，value为同一个房间的用户集合
     *      concurrentMap的key不存在时报错，不是返回null
     */
    private static int onlineCount = 0;
    private static final Map<String, Set<Session>> rooms = new ConcurrentHashMap();
    private static final Map<String, String> userNameList = new ConcurrentHashMap();

    @OnOpen
    public void connect(@PathParam("machineId") String machineId, @PathParam("userName") String username, Session session) throws Exception {
        // 将session按照房间名来存储，将各个房间的用户隔离
        logger.info("开始连接");
        if (!rooms.containsKey(machineId)) {
            System.out.println("xxxxx");
            // 创建房间不存在时，创建房间
            Set<Session> room = new HashSet<Session>();
            // 添加用户
            room.add(session);
            rooms.put(machineId, room);
        } else {
            // 房间已存在，直接添加用户到相应的房间
            rooms.get(machineId).add(session);
        }
        addOnlineCount();
        logger.info(username+" has connected!");
    }

    @OnClose
    public void disConnect(@PathParam("machineId") String machineId, @PathParam("userName") String userName, Session session) {
        rooms.get(machineId).remove(session);
        subOnlineCount();
        logger.info(userName+" has disconnected");
    }

    @OnMessage
    public void receiveMsg(@PathParam("machineId") String machineId, @PathParam("userName") String username,
                           String msg, Session session) throws Exception {
        // 此处应该有html过滤
        msg = username + ":" + msg;
        // 接收到信息后进行广播
        broadcast(machineId, msg);
    }

    /**
     *按照房间名进行广播
     * @param machineId
     * @param msg
     * @throws Exception
     */
    public static void broadcast(String machineId, String msg) throws IOException {
        System.out.println(rooms.get(machineId)!=null);
        if (rooms.get(machineId)!=null){
            for (Session session : rooms.get(machineId)) {
                logger.info("WEBSOCKET 广播:::::::>>>>>>>>>>>>>"+machineId);
                if (session!=null){
                    session.getBasicRemote().sendText(msg);
                }
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.onlineCount--;
    }

}