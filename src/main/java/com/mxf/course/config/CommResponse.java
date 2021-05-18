package com.mxf.course.config;

import java.io.Serializable;

/**
 * Created by baimao
 * Time:2020/4/2
 */

public class CommResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_TOKEN_EXPIRED = 2;
    public static final int STATUS_SUCCESS = 0;
    private String serialno;
    private int status;
    private T body;
    private String errorMessage;
    private String successMessage;
    private String warnMessage;

    public CommResponse() {
    }

    public String getSerialno() {
        return this.serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getBody() {
        return this.body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return this.successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getWarnMessage() {
        return this.warnMessage;
    }

    public void setWarnMessage(String warnMessage) {
        this.warnMessage = warnMessage;
    }

    public String toString() {
        return "CommResponse [status=" + this.status + ", body=" + this.body + ", errorMessage=" + this.errorMessage + ", successMessage=" + this.successMessage + ", warnMessage=" + this.warnMessage + "]";
    }
}
