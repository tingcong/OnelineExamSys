package com.tc.entity;

import java.io.Serializable;

/**
 * Created by htc on 2017/4/21.
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -145348220542983784L;

    /**
     * 学号
     */
    private Integer studentId;

    /**
     * 班级号码
     */
    private String classId;

    public Student() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
