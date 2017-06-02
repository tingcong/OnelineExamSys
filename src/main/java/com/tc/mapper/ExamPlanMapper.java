package com.tc.mapper;

import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;

import java.util.List;
import java.util.Map;

/**
 * Created by htc on 2017/4/21.
 */
public interface ExamPlanMapper {

    //即将到来的考试
    List<ExamPlan> getExamBe(Map map);

    //已经结束的考试
    List<ExamPlan> getExamEnd(Map map);

    //正在进行中的考试
    List<ExamPlan> getExamIng(Map map);

    //增加考试安排
    int insertExamPlan(Map map);

//    查询所有待设置的考试
    List<ExamPlan> getAllExamNotSet(int account);

    //根据考试编号获取考试安排信息
    ExamPlan getExamInfoById(int param);

//    添加考试题型和分数
    int updatePaperById(Map map);

    //保存分数
    Integer saveScore(Map map);

    //获取考试记录的总条数
    Integer getExamCount();

    //添加考试记录
    Integer insertExamRecord(Map map);

    //根据学号和考试编号获取考试记录
    ExamResult getExamRecordByStudentIdAndPaperId(Map map);

    //根据老师工号获取考试安排信息
    List<ExamPlan> getExamPlanByTeachId(Integer teacherId);

}
