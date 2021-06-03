package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_class")
public class ClassEntity {

  @Id
  private int id;
  private String classname;
  private String sketch;
  private int readsortid;
  private int stugroupid;
  private int teacherids;
  private int gradeid;
  private int schoolid;
  private String courseids;
  private int studentnumReg;
  private int studentnumAct;
  private int creatdate;
  private int expiredate;

    public ClassEntity(int id, String classname, String sketch, int readsortid, int stugroupid, int teacherids, int gradeid, int schoolid, String courseids, int studentnumReg, int studentnumAct, int creatdate, int expiredate) {
        this.id = id;
        this.classname = classname;
        this.sketch = sketch;
        this.readsortid = readsortid;
        this.stugroupid = stugroupid;
        this.teacherids = teacherids;
        this.gradeid = gradeid;
        this.schoolid = schoolid;
        this.courseids = courseids;
        this.studentnumReg = studentnumReg;
        this.studentnumAct = studentnumAct;
        this.creatdate = creatdate;
        this.expiredate = expiredate;
    }

    public ClassEntity() {
    }

    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }


  public String getSketch() {
    return sketch;
  }

  public void setSketch(String sketch) {
    this.sketch = sketch;
  }


  public int getReadsortid() {
    return readsortid;
  }

  public void setReadsortid(int readsortid) {
    this.readsortid = readsortid;
  }


  public int getStugroupid() {
    return stugroupid;
  }

  public void setStugroupid(int stugroupid) {
    this.stugroupid = stugroupid;
  }


  public int getTeacherids() {
    return teacherids;
  }

  public void setTeacherids(int teacherids) {
    this.teacherids = teacherids;
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


  public String getCourseids() {
    return courseids;
  }

  public void setCourseids(String courseids) {
    this.courseids = courseids;
  }


  public int getStudentnumReg() {
    return studentnumReg;
  }

  public void setStudentnumReg(int studentnumReg) {
    this.studentnumReg = studentnumReg;
  }


  public int getStudentnumAct() {
    return studentnumAct;
  }

  public void setStudentnumAct(int studentnumAct) {
    this.studentnumAct = studentnumAct;
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
