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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
    private String examName;
    private Integer subjectId;

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

    private String timeLimit;

    private String createDatetime;

    /**
     * 出卷老师
     */
    private Integer teacherId;

    private Integer singleNum;

    private Integer singleScope;

    private Integer doubleNum;

    private Integer getDoubleNum;

    private Integer judgmentNum;

    private Integer judgmentScope;

    private Integer essayNum;

    private Integer essayScope;
    private Integer totalScope;

    public Integer getTotalScope() {
        return totalScope;
    }

    public void setTotalScope(Integer totalScope) {
        this.totalScope = totalScope;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(Integer singleNum) {
        this.singleNum = singleNum;
    }

    public Integer getSingleScope() {
        return singleScope;
    }

    public void setSingleScope(Integer singleScope) {
        this.singleScope = singleScope;
    }

    public Integer getDoubleNum() {
        return doubleNum;
    }

    public void setDoubleNum(Integer doubleNum) {
        this.doubleNum = doubleNum;
    }

    public Integer getGetDoubleNum() {
        return getDoubleNum;
    }

    public void setGetDoubleNum(Integer getDoubleNum) {
        this.getDoubleNum = getDoubleNum;
    }

    public Integer getJudgmentNum() {
        return judgmentNum;
    }

    public void setJudgmentNum(Integer judgmentNum) {
        this.judgmentNum = judgmentNum;
    }

    public Integer getJudgmentScope() {
        return judgmentScope;
    }

    public void setJudgmentScope(Integer judgmentScope) {
        this.judgmentScope = judgmentScope;
    }

    public Integer getEssayNum() {
        return essayNum;
    }

    public void setEssayNum(Integer essayNum) {
        this.essayNum = essayNum;
    }

    public Integer getEssayScope() {
        return essayScope;
    }

    public void setEssayScope(Integer essayScope) {
        this.essayScope = essayScope;
    }

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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
