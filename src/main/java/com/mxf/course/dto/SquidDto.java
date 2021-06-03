package com.mxf.course.dto;

/**
 * Created by baimao
 * Time:2021/5/18
 */

public class SquidDto {

    private String connectionInfo;

    private String cacheInfo;

    private String mediaService;

    private String resouceUsage;

    private String memoryAccount;

    public SquidDto(String connectionInfo, String cacheInfo, String mediaService, String resouceUsage, String memoryAccount) {
        this.connectionInfo = connectionInfo;
        this.cacheInfo = cacheInfo;
        this.mediaService = mediaService;
        this.resouceUsage = resouceUsage;
        this.memoryAccount = memoryAccount;
    }

    public SquidDto() {
    }

    public String getConnectionInfo() {
        return connectionInfo;
    }

    public void setConnectionInfo(String connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public String getCacheInfo() {
        return cacheInfo;
    }

    public void setCacheInfo(String cacheInfo) {
        this.cacheInfo = cacheInfo;
    }

    public String getMediaService() {
        return mediaService;
    }

    public void setMediaService(String mediaService) {
        this.mediaService = mediaService;
    }

    public String getResouceUsage() {
        return resouceUsage;
    }

    public void setResouceUsage(String resouceUsage) {
        this.resouceUsage = resouceUsage;
    }

    public String getMemoryAccount() {
        return memoryAccount;
    }

    public void setMemoryAccount(String memoryAccount) {
        this.memoryAccount = memoryAccount;
    }
}
