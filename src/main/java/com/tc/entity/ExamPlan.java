package com.tc.entity;

import java.io.Serializable;

/**
 * 考试安排表
 * Created by htc on 2017/4/21.
 */
public class ExamPlan implements Serializable {

    private static final long serialVersionUID = -2577728687837412275L;

    /**
     * 考试编号
     */
    private Integer id;

    /**
     * 试卷编号
     */
    private Integer paperId;

    /**
     * 参与考试的班级
     */
    private String classId;

    /**
     * 考试开始时间
     */
    private String examStartDatetime;

    /**
     * 考试结束限时
     */
    private String examEndDatetime;

    public ExamPlan() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getExamStartDatetime() {
        return examStartDatetime;
    }

    public void setExamStartDatetime(String examStartDatetime) {
        this.examStartDatetime = examStartDatetime;
    }

    public String getExamEndDatetime() {
        return examEndDatetime;
    }

    public void setExamEndDatetime(String examEndDatetime) {
        this.examEndDatetime = examEndDatetime;
    }
}
