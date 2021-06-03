package com.mxf.course.dto;

/**
 * Created by baimao
 * Time:2021/5/28
 */

public class ClassDto {

    private int id;

    private String classname;

    private String sketch;

    private int schoolid;

    private String schoolname;

    private String gradeid;

    private String gradename;

    private int studentnum;

    private int creatdate;

    public ClassDto(int id, String classname, String sketch, int schoolid, String schoolname, String gradeid, String gradename, int studentnum, int creatdate) {
        this.id = id;
        this.classname = classname;
        this.sketch = sketch;
        this.schoolid = schoolid;
        this.schoolname = schoolname;
        this.gradeid = gradeid;
        this.gradename = gradename;
        this.studentnum = studentnum;
        this.creatdate = creatdate;
    }

    public ClassDto() {
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

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getGradeid() {
        return gradeid;
    }

    public void setGradeid(String gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
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
}
