package com.mxf.course.entity;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_student")
public class StudentEntity {
  @Id
  private int id;

  private int uid;
  private int classid;
  private int gradeid;
  private int schoolid;
  private int worksnum;
  private int expiredate;
  private int regtime;

    public StudentEntity() {
    }

    public StudentEntity(int id, int uid, int classid, int gradeid, int schoolid, int worksnum, int expiredate, int regtime) {
        this.id = id;
        this.uid = uid;
        this.classid = classid;
        this.gradeid = gradeid;
        this.schoolid = schoolid;
        this.worksnum = worksnum;
        this.expiredate = expiredate;
        this.regtime = regtime;
    }

    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public int getClassid() {
    return classid;
  }

  public void setClassid(int classid) {
    this.classid = classid;
  }


  public int getGradeid() {
    return gradeid;
  }

  public void setGradeid(int gradeid) {
    this.gradeid = gradeid;
  }


  public int getSchoolid() {
    return schoolid;
  }

  public void setSchoolid(int schoolid) {
    this.schoolid = schoolid;
  }


  public int getWorksnum() {
    return worksnum;
  }

  public void setWorksnum(int worksnum) {
    this.worksnum = worksnum;
  }


  public int getExpiredate() {
    return expiredate;
  }

  public void setExpiredate(int expiredate) {
    this.expiredate = expiredate;
  }


  public int getRegtime() {
    return regtime;
  }

  public void setRegtime(int regtime) {
    this.regtime = regtime;
  }

}
