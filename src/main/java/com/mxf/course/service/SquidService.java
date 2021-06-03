package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.SquidMapper;
import com.mxf.course.entity.SquidEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/25
 */

@Service
public class SquidService {

    @Resource
    SquidMapper squidMapper;

    public PageInfo selectSquidByConditions(int currentPage, int pageSize, String name, String port,String ip){
        PageHelper.startPage(currentPage,pageSize);
        List<SquidEntity> squidEntityList = squidMapper.selectAllSquidByConditions(port,ip,name);
        PageInfo pageInfo = new PageInfo(squidEntityList);
        return pageInfo;
    }

    public String insertSquid(String name,int port ) throws ScExtException {
        if (squidMapper.selectSquidByName(name)!=null){
            throw new ScExtException("请勿重复添加相同地址");
        }

        if (squidMapper.selectSquidByPorts(port)!=null){
            throw new ScExtException("该端口已占用");
        }
        String[] ips = name.split("\n");
        String ip = name;
        if (ips.length > 1){
            ip = ips[1];
        }
        System.out.println(ip);
        SquidEntity squidEntity = new SquidEntity();
        squidEntity.setName(name);
        squidEntity.setIp(ip);
        squidEntity.setDate(new Date());
        squidEntity.setOutport(port);
        squidEntity.setStatus(0);
        if (squidMapper.insertSelective(squidEntity)<0){
            throw new ScExtException("添加Squid失败");
        }
        return "success";
    }

    public String updateSquid(int port,int status) throws ScExtException {
        SquidEntity squidEntity = squidMapper.selectSquidByPorts(port);
        if (squidEntity==null){
            throw new ScExtException("该主机未注册到服务器");
        }
        squidEntity.setStatus(status);
        if (squidMapper.updateByPrimaryKeySelective(squidEntity)<0){
            throw new ScExtException("修改Squid失败");
        }
        return "success";
    }

    public List<Integer> selectAllSquidPort(){
        List<Integer> ports = squidMapper.selectAllPorts();
        return ports;
    }


}
