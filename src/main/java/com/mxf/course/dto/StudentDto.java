package com.mxf.course.dto;

/**
 * Created by baimao
 * Time:2021/5/24
 */

public class StudentDto {
    private int id;

    private String username;

    private String nickname;

    private String classname;

    private String schoolname;

    private int schoolid;

    private String gradename;

    private int gradeid;

    private int creatdate;

    public StudentDto(int id, String username, String nickname, String classname, String schoolname, int schoolid, String gradename, int gradeid, int creatdate) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.classname = classname;
        this.schoolname = schoolname;
        this.schoolid = schoolid;
        this.gradename = gradename;
        this.gradeid = gradeid;
        this.creatdate = creatdate;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public StudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(int creatdate) {
        this.creatdate = creatdate;
    }
}
