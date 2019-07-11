package com.wq.springioc.bean;

public class Course {
    private String id;

    private String courseName;

    private String teacherName;


    public void init(){
        System.out.println("老师来上课啦，赶紧过来......");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
