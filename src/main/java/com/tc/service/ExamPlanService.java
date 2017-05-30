package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.entity.Resp;
import com.tc.mapper.ExamPlanMapper;
import com.tc.utils.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * 生成试卷
     * @param examId
     * @return
     */
    public Resp getPaper(Integer examId,String path) throws Exception {
        Resp resp=new Resp();
        List<Object> paperDetail=new ArrayList<>();

        ExamPlan examPlan=getExamInfoById(examId);
        int singleNum=examPlan.getSingleNum();
        int DoubleNum=examPlan.getDoubleNum();
        int JudgemenNum=examPlan.getJudgmentNum();
        int EssayNum=examPlan.getEssayNum();
        int subjectId=examPlan.getSubjectId();
//        path=path+"\\1\\1-1.xml";
        System.out.println(path);
//        String filePath=projectRootRealPath+"\\src\\main\\webapp\\file\\questionLibrary\\"+map.get("subject")+"\\"+map.get("questionType")+"-"+map.get("level")+".xml";
      //获取题库中的各类题型的题量
        int singleCount=XMLUtil.getTotal(path+"\\"+subjectId+"\\1-1.xml");
        int DoubleCount=XMLUtil.getTotal(path+"\\"+subjectId+"\\2-1.xml");
        int JudgemenCount=XMLUtil.getTotal(path+"\\"+subjectId+"\\3-1.xml");
        int EssayCount=XMLUtil.getTotal(path+"\\"+subjectId+"\\4-1.xml");
//        System.out.println(singleCount+"..."+DoubleCount+"..."+JudgemenCount+"..."+EssayCount);
        //获取试卷题号列表
        Set<Integer> singleSet= XMLUtil.getRandom(singleCount,singleNum);
        Set<Integer> DoubleSet= XMLUtil.getRandom(DoubleCount,DoubleNum);
        Set<Integer> JudgemenSet= XMLUtil.getRandom(JudgemenCount,JudgemenNum);
        Set<Integer> EssaySet= XMLUtil.getRandom(EssayCount,EssayNum);

        //根据题号获取题目信息
        //单选
        List<Object> singleList=new ArrayList<>();
        Iterator<Integer> singleIt=singleSet.iterator();
        while (singleIt.hasNext()){
//            singleList.add(XMLUtil.getSingleDetail(singleIt.next(),path+"\\"+subjectId+"\\1-1.xml"));
            paperDetail.add(XMLUtil.getSingleDetail(singleIt.next(),path+"\\"+subjectId+"\\1-1.xml"));
        }
        //多选
        List<Object> doubleList=new ArrayList<>();
        Iterator<Integer> doubleIt=DoubleSet.iterator();
        while (doubleIt.hasNext()){
//            doubleList.add(XMLUtil.getSingleDetail(doubleIt.next(),path+"\\"+subjectId+"\\2-1.xml"));
            paperDetail.add(XMLUtil.getSingleDetail(doubleIt.next(),path+"\\"+subjectId+"\\2-1.xml"));
        }
//        System.out.println(doubleList.toString());

        //判断正误
        List<Object> judgemenList=new ArrayList<>();
        Iterator<Integer> judgemengIt=JudgemenSet.iterator();
        while(judgemengIt.hasNext()){
//            judgemenList.add(XMLUtil.getJudgmenDetail(judgemengIt.next(),path+"\\"+subjectId+"\\3-1.xml"));
            paperDetail.add(XMLUtil.getJudgmenDetail(judgemengIt.next(),path+"\\"+subjectId+"\\3-1.xml"));
        }

        //问答题
        List<Object> essayList=new ArrayList<>();
        Iterator<Integer> essayIt=EssaySet.iterator();
        while(essayIt.hasNext()){
//            essayList.add(XMLUtil.getEssayDetail(essayIt.next(),path+"\\"+subjectId+"\\3-1.xml"));
            paperDetail.add(XMLUtil.getEssayDetail(essayIt.next(),path+"\\"+subjectId+"\\3-1.xml"));
        }

        //试卷信息汇总
//        paperDetail.add(singleList);
//        paperDetail.add(doubleList);
//        paperDetail.add(judgemenList);
//        paperDetail.add(essayList);
        System.out.println(paperDetail.toString());

        resp.setData(paperDetail);
        return resp;
    }
}
