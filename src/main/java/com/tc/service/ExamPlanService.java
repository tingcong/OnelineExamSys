package com.tc.service;

import com.tc.mapper.ExamPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
