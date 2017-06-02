package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;
import com.tc.mapper.ExamPlanMapper;
import com.tc.mapper.ExamResultMapper;
import com.tc.utils.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TingCong on 2017/6/1.
 */
@Service
public class ExamResultService {

    @Autowired
    private ExamResultMapper examResultMapper;

    @Autowired
    private ExamPlanMapper examPlanMapper;

    /**
     * 学生获取考试成绩信息
     *
     * @param studentId
     * @return
     */
    public List<ExamResult> getExamResultByStudentId(Integer studentId) {
        return examResultMapper.getExamResult(studentId);
    }


    //获取未批改的试卷
    public List<Object> getNotCorrection(Map map) throws Exception {
        //根据老师工号获取考试记录
        List<ExamPlan> examPlanList = examPlanMapper.getExamPlanByTeachId(Integer.parseInt(map.get("account").toString()));
        List<Integer> examIdList = new ArrayList<>();
        List<Map> resultListMap=new ArrayList<>();
        for (int i = 0; i < examPlanList.size(); i++) {
            for (int j = 0; j < 6; j++) {
                Map map_s=map;
                map_s.put("filePath", map.get("filePath") + "\\" + (j+1) + "\\result.xml");
                map_s.put("examId", examPlanList.get(i).getId());
                List<Map> mapList=XMLUtil.getNotCorrection(map_s);
            }
        }
        return null;
    }
}
