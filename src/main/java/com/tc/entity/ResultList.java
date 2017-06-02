package com.tc.entity;

import java.io.Serializable;

/**
 * Created by TingCong on 2017/6/2.
 */
public class ResultList implements Serializable {
    private static final long serialVersionUID = -6759292504529659698L;
    private Integer studentId;
    private Integer classId;
    private String studentName;
    private String examName;
    private Integer totalScore;

    public ResultList() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
