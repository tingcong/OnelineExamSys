package com.tc.mapper;

import com.tc.entity.ExamResult;

import java.util.List;

/**
 * Created by TingCong on 2017/6/1.
 */
public interface ExamResultMapper {
    //学生获取考试结果
    List<ExamResult> getExamResult(Integer studentId);
}
