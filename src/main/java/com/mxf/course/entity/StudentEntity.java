package com.mxf.course.entity;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_student")
public class StudentEntity {
  @Id
  private long id;

  private long uid;
  private long classid;
  private long gradeid;
  private long schoolid;
  private long worksnum;
  private long expiredate;
  private long regtime;

    public StudentEntity() {
    }

    public StudentEntity(long id, long uid, long classid, long gradeid, long schoolid, long worksnum, long expiredate, long regtime) {
        this.id = id;
        this.uid = uid;
        this.classid = classid;
        this.gradeid = gradeid;
        this.schoolid = schoolid;
        this.worksnum = worksnum;
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


  public long getClassid() {
    return classid;
  }

  public void setClassid(long classid) {
    this.classid = classid;
  }


  public long getGradeid() {
    return gradeid;
  }

  public void setGradeid(long gradeid) {
    this.gradeid = gradeid;
  }


  public long getSchoolid() {
    return schoolid;
  }

  public void setSchoolid(long schoolid) {
    this.schoolid = schoolid;
  }


  public long getWorksnum() {
    return worksnum;
  }

  public void setWorksnum(long worksnum) {
    this.worksnum = worksnum;
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
