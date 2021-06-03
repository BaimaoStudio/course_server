package com.mxf.course.entity;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yz_jxgl_course")
public class CourseEntity {

    @Id
  private int id;
  private String coursename;
  private String sketch;
  private int sortid;
  private String logourl;
  private String quanxian;

  private String content;

    public CourseEntity(int id, String coursename, String sketch, int sortid, String logourl, String quanxian, String content) {
        this.id = id;
        this.coursename = coursename;
        this.sketch = sketch;
        this.sortid = sortid;
        this.logourl = logourl;
        this.quanxian = quanxian;
        this.content = content;
    }

    public CourseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
