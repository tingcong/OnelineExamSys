package com.tc.mapper;

import com.tc.entity.ExamPlan;

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

}
