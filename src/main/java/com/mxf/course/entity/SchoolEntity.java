package com.mxf.course.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_school")
public class SchoolEntity {

    @Id
  private int id;
  private String schoolname;
  private String sketch;
  private int code;
  private int readsortid;
  private String type;
  private int stugroupid;
  private String detail;
  private String grade;
  private int studentnum;
  private int gradenum;
  private int classnum;
  private String province;
  private int creatdate;
  private String city;
  private String district;
  private int expiredate;

    public SchoolEntity() {
    }

    public SchoolEntity(int id, String schoolname, String sketch, int code, int readsortid, String type, int stugroupid, String detail, String grade, int studentnum, int gradenum, int classnum, String province, int creatdate, String city, String district, int expiredate) {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getReadsortid() {
        return readsortid;
    }

    public void setReadsortid(int readsortid) {
        this.readsortid = readsortid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStugroupid() {
        return stugroupid;
    }

    public void setStugroupid(int stugroupid) {
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

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }

    public int getGradenum() {
        return gradenum;
    }

    public void setGradenum(int gradenum) {
        this.gradenum = gradenum;
    }

    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(int creatdate) {
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

    public int getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(int expiredate) {
        this.expiredate = expiredate;
    }
}
