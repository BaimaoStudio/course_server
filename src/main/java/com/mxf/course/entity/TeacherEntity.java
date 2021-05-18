package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_teacher")
public class TeacherEntity {

    @Id
  private long id;
  private long uid;
  private String teachername;
  private String classids;
  private long schoolid;
  private long expiredate;
  private long regtime;

    public TeacherEntity() {
    }

    public TeacherEntity(long id, long uid, String teachername, String classids, long schoolid, long expiredate, long regtime) {
        this.id = id;
        this.uid = uid;
        this.teachername = teachername;
        this.classids = classids;
        this.schoolid = schoolid;
        this.expiredate = expiredate;
        this.regtime = regtime;
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getTeachername() {
    return teachername;
  }

  public void setTeachername(String teachername) {
    this.teachername = teachername;
  }


  public String getClassids() {
    return classids;
  }

  public void setClassids(String classids) {
    this.classids = classids;
  }


  public long getSchoolid() {
    return schoolid;
  }

  public void setSchoolid(long schoolid) {
    this.schoolid = schoolid;
  }


  public long getExpiredate() {
    return expiredate;
  }

  public void setExpiredate(long expiredate) {
    this.expiredate = expiredate;
  }


  public long getRegtime() {
    return regtime;
  }

  public void setRegtime(long regtime) {
    this.regtime = regtime;
  }

}
