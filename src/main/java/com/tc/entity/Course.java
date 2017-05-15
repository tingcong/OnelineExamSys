package com.tc.entity;

import java.io.Serializable;

/**
 * Created by htc on 2017/5/15.
 */
public class Course implements Serializable{

    private static final long serialVersionUID = 1647896545488910126L;

    private Integer courseId;

    private String courseName;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
