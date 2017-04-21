package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.mapper.ExamPlanMapper;
import com.tc.utils.DatetimeUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by htc on 2017/4/21.
 */
@Service
public class StudentService {
    @Autowired
    private ExamPlanMapper examPlanMapper;

    public List<ExamPlan> getExamBe(Integer studentId){
        Map map=new HashedMap();
        map.put("studentId",studentId);
        map.put("nowDatetime", DatetimeUtil.getLocalDatetime());
        return examPlanMapper.getExamBe(map);
    }
}
