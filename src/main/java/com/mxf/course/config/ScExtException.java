package com.mxf.course.config;

import java.io.Serializable;

/**
 * Created by baimao
 * Time:2020/4/2
 */

public class ScExtException extends Exception implements Serializable {
    private static final long serialVersionUID = -1944206179214394839L;
    private String errCode;
    private String errMsg;
    private String[] args;
    private String action;

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        if (this.args != null) {
            for(int i = 1; i <= this.args.length; ++i) {
                this.errMsg = this.errMsg.replace("{" + i + "}", this.args[i - 1]);
            }
        }

        return this.errMsg;
    }

    public String getAction() {
        return this.action;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public ScExtException(String action, String errCode, String errMsg, String... args) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.args = args;
        this.action = action;
    }

    public ScExtException(String action, String[] err, String... args) {
        this.errCode = err[0];
        this.errMsg = err[1];
        this.args = args;
        this.action = action;
    }

    public ScExtException(String[] err, String... args) {
        this.errCode = err[0];
        this.errMsg = err[1];
        this.args = args;
    }

    public ScExtException(String errMsg) {
        this("", "1000", errMsg);
    }

    public ScExtException(String action, String errMsg) {
        this(action, "1000", errMsg);
    }
}
