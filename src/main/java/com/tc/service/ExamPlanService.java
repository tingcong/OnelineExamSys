package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.mapper.ExamPlanMapper;
import com.tc.utils.GetDatetimeUtil;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by htc on 2017/4/21.
 */
@Service
public class ExamPlanService {
    @Autowired
    private ExamPlanMapper examPlanMapper;


}
