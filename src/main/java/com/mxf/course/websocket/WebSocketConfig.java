package com.mxf.course.websocket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Create By  Baimao
 * Time:2019-04-24 0:17
 */
@EnableWebSocket
@Configuration
public class WebSocketConfig {
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            System.out.println("START CONFIG");
            return new ServerEndpointExporter();
        }
}