package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.mapper.ExamPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by htc on 2017/4/21.
 */
@Service
public class ExamPlanService {
    @Autowired
    private ExamPlanMapper examPlanMapper;

    public int insertExamPlan(Map map){
        return examPlanMapper.insertExamPlan(map);
    }

    public List<ExamPlan> getAllExamNotSet(int account){
        return examPlanMapper.getAllExamNotSet(account);
    }

    /*  根据考试编号获取考试安排信息    */
    public ExamPlan getExamInfoById(int param){
        return examPlanMapper.getExamInfoById(param);
    }

    /*添加考试题型和分数*/
    public int updatePaperById(Map map){
        return examPlanMapper.updatePaperById(map);
    }
}
