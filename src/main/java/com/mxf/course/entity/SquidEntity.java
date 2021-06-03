package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by baimao
 * Time:2021/5/25
 */

@Table(name = "yz_squid")
public class SquidEntity {

    @Id
    private int id;

    private String password;

    private String ip;

    private String name;

    private int outport;

    private int status;

    private Date date;


    public SquidEntity() {
    }


    public SquidEntity(int id, String password, String ip, String name, int outport, int status, Date date) {
        this.id = id;
        this.password = password;
        this.ip = ip;
        this.name = name;
        this.outport = outport;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOutport() {
        return outport;
    }

    public void setOutport(int outport) {
        this.outport = outport;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


