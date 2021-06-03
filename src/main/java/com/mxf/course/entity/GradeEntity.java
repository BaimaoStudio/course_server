package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_grade")

public class GradeEntity {

    @Id
  private int id;
  private String gradename;
  private String type;
  private int year;
  private int readsortid;
  private int schoolid;
  private int classnum;
  private int studentnum;
  private int creatdate;
  private int expiredate;

    public GradeEntity() {
    }

    public GradeEntity(int id, String gradename, String type, int year, int readsortid, int schoolid, int classnum, int studentnum, int creatdate, int expiredate) {
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

    public int getId() {
    return id;
  }

  public void setId(int id) {
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


  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }


  public int getReadsortid() {
    return readsortid;
  }

  public void setReadsortid(int readsortid) {
    this.readsortid = readsortid;
  }


  public int getSchoolid() {
    return schoolid;
  }

  public void setSchoolid(int schoolid) {
    this.schoolid = schoolid;
  }


  public int getClassnum() {
    return classnum;
  }

  public void setClassnum(int classnum) {
    this.classnum = classnum;
  }


  public int getStudentnum() {
    return studentnum;
  }

  public void setStudentnum(int studentnum) {
    this.studentnum = studentnum;
  }


  public int getCreatdate() {
    return creatdate;
  }

  public void setCreatdate(int creatdate) {
    this.creatdate = creatdate;
  }


  public int getExpiredate() {
    return expiredate;
  }

  public void setExpiredate(int expiredate) {
    this.expiredate = expiredate;
  }

}
