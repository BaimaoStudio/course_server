package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by baimao
 * Time:2021/5/28
 */

@Table(name = "yz_jxgl_log")
public class LogEntity {

    @Id
    private int id;

    private String serialno;

    private int status;

    private String body;

    private String errorMessage;

    private String successMessage;

    private Date time;

    public LogEntity(int id, String serialno, int status, String body, String errorMessage, String successMessage, Date time) {
        this.id = id;
        this.serialno = serialno;
        this.status = status;
        this.body = body;
        this.errorMessage = errorMessage;
        this.successMessage = successMessage;
        this.time = time;
    }

    public LogEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
