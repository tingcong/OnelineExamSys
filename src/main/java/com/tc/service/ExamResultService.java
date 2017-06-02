package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;
import com.tc.entity.ResultList;
import com.tc.mapper.ExamPlanMapper;
import com.tc.mapper.ExamResultMapper;
import com.tc.utils.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public List<Map> getNotCorrection(Map map) throws Exception {
        //根据老师工号获取考试记录
//        List<ExamPlan> examPlanList = examPlanMapper.getExamPlanByTeachId(Integer.parseInt(map.get("account").toString()));
//        List<Integer> examIdList = new ArrayList<>();
//        List<Map> resultListMap=new ArrayList<>();
//        for (int i = 0; i < examPlanList.size(); i++) {
//            for (int j = 0; j < 6; j++) {
//                String filePath=map.get("filePath").toString();
//                Map map_s=new HashMap();
//                map_s.put("filePath", filePath + "\\" + (j+1) + "\\result.xml");
//                map_s.put("examId", examPlanList.get(i).getId());
//                XMLUtil.getNotCorrection(map_s).toString();
//            }
//        }

        List<Map> resultListMap = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            String filePath = map.get("filePath").toString();
            Map map_s = new HashMap();
            map_s.put("filePath", filePath + "\\" + (j + 1) + "\\result.xml");
            map_s.put("examId", map.get("paperId"));
//            XMLUtil.getNotCorrection(map_s);
            if(XMLUtil.getNotCorrection(map_s).size()>0){
                resultListMap.addAll(XMLUtil.getNotCorrection(map_s));
            }
        }
        return resultListMap;
    }

    public int updateEssayScore(Map<Integer,Integer> map,Integer paperId){
        try {
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                Map<String,Integer> map1=new HashMap<>();
                map1.put("score",entry.getValue());
                map1.put("studentId",entry.getKey());
                map1.put("paperId",paperId);
                examResultMapper.updateEssayScore(map1);
    //            examResultMapper.updateEssayScore(entry.getValue(),entry.getKey(),paperId);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateTotalScore(Map map){
        return examResultMapper.updateTotalScore(map);
    }

    public List<ResultList> getResultList(){
        return examResultMapper.getResultList();
    }
}
