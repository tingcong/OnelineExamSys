package com.tc.mapper;

import com.tc.entity.ExamResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by TingCong on 2017/6/1.
 */
public interface ExamResultMapper {
    //学生获取考试结果
    List<ExamResult> getExamResult(Integer studentId);

    //更新essay分数
    int updateEssayScore(Map<String,Integer> map);

    int updateTotalScore(Map<String,Integer> map);
}
