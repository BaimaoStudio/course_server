package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_grade")

public class GradeEntity {

    @Id
  private long id;
  private String gradename;
  private String type;
  private long year;
  private long readsortid;
  private long schoolid;
  private long classnum;
  private long studentnum;
  private long creatdate;
  private long expiredate;

    public GradeEntity() {
    }

    public GradeEntity(long id, String gradename, String type, long year, long readsortid, long schoolid, long classnum, long studentnum, long creatdate, long expiredate) {
        this.id = id;
        this.gradename = gradename;
        this.type = type;
        this.year = year;
        this.readsortid = readsortid;
        this.schoolid = schoolid;
        this.classnum = classnum;
        this.studentnum = studentnum;
        this.creatdate = creatdate;
        this.expiredate = expiredate;
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGradename() {
    return gradename;
  }

  public void setGradename(String gradename) {
    this.gradename = gradename;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public long getReadsortid() {
    return readsortid;
  }

  public void setReadsortid(long readsortid) {
    this.readsortid = readsortid;
  }


  public long getSchoolid() {
    return schoolid;
  }

  public void setSchoolid(long schoolid) {
    this.schoolid = schoolid;
  }


  public long getClassnum() {
    return classnum;
  }

  public void setClassnum(long classnum) {
    this.classnum = classnum;
  }


  public long getStudentnum() {
    return studentnum;
  }

  public void setStudentnum(long studentnum) {
    this.studentnum = studentnum;
  }


  public long getCreatdate() {
    return creatdate;
  }

  public void setCreatdate(long creatdate) {
    this.creatdate = creatdate;
  }


  public long getExpiredate() {
    return expiredate;
  }

  public void setExpiredate(long expiredate) {
    this.expiredate = expiredate;
  }

}
