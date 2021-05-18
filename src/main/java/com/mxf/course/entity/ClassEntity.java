package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_class")
public class ClassEntity {

  @Id
  private long id;
  private String classname;
  private String sketch;
  private long readsortid;
  private long stugroupid;
  private long teacherids;
  private long gradeid;
  private long schoolid;
  private String courseids;
  private long studentnumReg;
  private long studentnumAct;
  private long creatdate;
  private long expiredate;

    public ClassEntity(long id, String classname, String sketch, long readsortid, long stugroupid, long teacherids, long gradeid, long schoolid, String courseids, long studentnumReg, long studentnumAct, long creatdate, long expiredate) {
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

    public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public long getReadsortid() {
    return readsortid;
  }

  public void setReadsortid(long readsortid) {
    this.readsortid = readsortid;
  }


  public long getStugroupid() {
    return stugroupid;
  }

  public void setStugroupid(long stugroupid) {
    this.stugroupid = stugroupid;
  }


  public long getTeacherids() {
    return teacherids;
  }

  public void setTeacherids(long teacherids) {
    this.teacherids = teacherids;
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


  public String getCourseids() {
    return courseids;
  }

  public void setCourseids(String courseids) {
    this.courseids = courseids;
  }


  public long getStudentnumReg() {
    return studentnumReg;
  }

  public void setStudentnumReg(long studentnumReg) {
    this.studentnumReg = studentnumReg;
  }


  public long getStudentnumAct() {
    return studentnumAct;
  }

  public void setStudentnumAct(long studentnumAct) {
    this.studentnumAct = studentnumAct;
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
