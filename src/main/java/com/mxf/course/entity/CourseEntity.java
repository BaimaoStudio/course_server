package com.mxf.course.entity;



public class CourseEntity {

  private long id;
  private String coursename;
  private String sketch;
  private long sortid;
  private String logourl;
  private String quanxian;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public long getSortid() {
    return sortid;
  }

  public void setSortid(long sortid) {
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

}
