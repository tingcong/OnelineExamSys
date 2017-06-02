package com.tc.entity;

import java.io.Serializable;

/**
 * Created by TingCong on 2017/6/1.
 */
public class ExamResult implements Serializable{
    private static final long serialVersionUID = 4758855097445631216L;
    private Integer id;
    private Integer paperId;
    private String examName;
    private Integer studentId;
    private Integer singleScore;
    private Integer multiScore;
    private Integer judgeScore;
    private Integer essayScore;
    private Integer totalScore;
    private String startTime;
    private String endTime;

    public ExamResult() {
        super();
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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Integer singleScore) {
        this.singleScore = singleScore;
    }

    public Integer getMultiScore() {
        return multiScore;
    }

    public void setMultiScore(Integer multiScore) {
        this.multiScore = multiScore;
    }

    public Integer getJudgeScore() {
        return judgeScore;
    }

    public void setJudgeScore(Integer judgeScore) {
        this.judgeScore = judgeScore;
    }

    public Integer getEssayScore() {
        return essayScore;
    }

    public void setEssayScore(Integer essayScore) {
        this.essayScore = essayScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
