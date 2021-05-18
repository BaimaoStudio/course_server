package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_work")
public class WorkEntity {

    @Id
  private long id;
  private String workname;
  private long zpid;
  private long uid;
  private long studentid;
  private long classid;
  private double score;
  private long status;
  private String type;
  private long date;

    public WorkEntity() {
    }

    public WorkEntity(long id, String workname, long zpid, long uid, long studentid, long classid, double score, long status, String type, long date) {
        this.id = id;
        this.workname = workname;
        this.zpid = zpid;
        this.uid = uid;
        this.studentid = studentid;
        this.classid = classid;
        this.score = score;
        this.status = status;
        this.type = type;
        this.date = date;
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getWorkname() {
    return workname;
  }

  public void setWorkname(String workname) {
    this.workname = workname;
  }


  public long getZpid() {
    return zpid;
  }

  public void setZpid(long zpid) {
    this.zpid = zpid;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public long getStudentid() {
    return studentid;
  }

  public void setStudentid(long studentid) {
    this.studentid = studentid;
  }


  public long getClassid() {
    return classid;
  }

  public void setClassid(long classid) {
    this.classid = classid;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

}
