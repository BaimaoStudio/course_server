package com.mxf.course.dto;

/**
 * Created by baimao
 * Time:2021/5/28
 */

public class GradeDetailDto {

    private int id;

    private String gradename;

    private int studentnum;

    private int classnum;

    private String schoolname;

    private int createtime;

    public GradeDetailDto(int id, String gradename, int studentnum, int classnum, String schoolname, int createtime) {
        this.id = id;
        this.gradename = gradename;
        this.studentnum = studentnum;
        this.classnum = classnum;
        this.schoolname = schoolname;
        this.createtime = createtime;
    }

    public GradeDetailDto() {
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
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

    public int getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(int studentnum) {
        this.studentnum = studentnum;
    }

    public int getClassnum() {
        return classnum;
    }

    public void setClassnum(int classnum) {
        this.classnum = classnum;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
}
