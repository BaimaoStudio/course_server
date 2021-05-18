package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_school")

public class SchoolEntity {

    @Id
  private long id;
  private String schoolname;
  private String sketch;
  private long code;
  private long readsortid;
  private String type;
  private long stugroupid;
  private String detail;
  private String grade;
  private long studentnum;
  private long gradenum;
  private long classnum;
  private String province;
  private long creatdate;
  private String city;
  private String district;
  private long expiredate;

    public SchoolEntity() {
    }

    public SchoolEntity(long id, String schoolname, String sketch, long code, long readsortid, String type, long stugroupid, String detail, String grade, long studentnum, long gradenum, long classnum, String province, long creatdate, String city, String district, long expiredate) {
        this.id = id;
        this.schoolname = schoolname;
        this.sketch = sketch;
        this.code = code;
        this.readsortid = readsortid;
        this.type = type;
        this.stugroupid = stugroupid;
        this.detail = detail;
        this.grade = grade;
        this.studentnum = studentnum;
        this.gradenum = gradenum;
        this.classnum = classnum;
        this.province = province;
        this.creatdate = creatdate;
        this.city = city;
        this.district = district;
        this.expiredate = expiredate;
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSchoolname() {
    return schoolname;
  }

  public void setSchoolname(String schoolname) {
    this.schoolname = schoolname;
  }


  public String getSketch() {
    return sketch;
  }

  public void setSketch(String sketch) {
    this.sketch = sketch;
  }


  public long getCode() {
    return code;
  }

  public void setCode(long code) {
    this.code = code;
  }


  public long getReadsortid() {
    return readsortid;
  }

  public void setReadsortid(long readsortid) {
    this.readsortid = readsortid;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getStugroupid() {
    return stugroupid;
  }

  public void setStugroupid(long stugroupid) {
    this.stugroupid = stugroupid;
  }


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public long getStudentnum() {
    return studentnum;
  }

  public void setStudentnum(long studentnum) {
    this.studentnum = studentnum;
  }


  public long getGradenum() {
    return gradenum;
  }

  public void setGradenum(long gradenum) {
    this.gradenum = gradenum;
  }


  public long getClassnum() {
    return classnum;
  }

  public void setClassnum(long classnum) {
    this.classnum = classnum;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public long getCreatdate() {
    return creatdate;
  }

  public void setCreatdate(long creatdate) {
    this.creatdate = creatdate;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }


  public long getExpiredate() {
    return expiredate;
  }

  public void setExpiredate(long expiredate) {
    this.expiredate = expiredate;
  }

}
