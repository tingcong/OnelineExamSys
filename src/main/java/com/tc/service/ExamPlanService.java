package com.tc.service;

import com.tc.entity.ExamPlan;
import com.tc.entity.ExamResult;
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
//            essayList.add(XMLUtil.getEssayDetail(essayIt.next(),path+"\\"+subjectId+"\\4-1.xml"));
            paperDetail.add(XMLUtil.getEssayDetail(essayIt.next(),path+"\\"+subjectId+"\\4-1.xml"));
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

    /**
     * 提交试卷，系统自动批改
     * @param mapList
     * @return
     */
    public Resp putPaper(List<Map<String,String>> mapList,String filePathParam,String account) throws Exception {
        //存放系统自动阅卷的分数
        Map<String,Integer> mapScore=new HashMap<>();
        //单选题总分
        Integer singleScore=0;
        //多选题总分
        Integer douleScore=0;
        //判断题总分
        Integer judgeScore=0;
        //问答题总分
        Integer essayScore=0;

        //题目批改，选择、判断系统自动评卷，问答题则存入文件等待老师批改
        for (int i = 0; i <mapList.size() ; i++) {
            //请求答案的参数
            Map paramMap=new HashMap();
            Map<String,String> map=mapList.get(i);
            String filePath=filePathParam+"\\"+map.get("subject").trim()+"\\"+map.get("questionType").trim()+"-1.xml";
//            System.out.println(filePath);
            paramMap.put("filePath",filePath);
            //单项选择，判断
            if(map.get("questionType").equals("1")){
                paramMap.put("id",map.get("questionId").trim());
                String answer=XMLUtil.getAnswer(paramMap);
                //答案正确
                if(answer.equals(map.get("answer").trim())){
                    singleScore=singleScore+5;
                }
//                System.out.println(answer);
            }else if(map.get("questionType").equals("2")){  //多选
//                System.out.println(map.get("answer").replace("|","").replace(" ",""));
                paramMap.put("id",map.get("questionId").trim());
                String answer=XMLUtil.getAnswer(paramMap);
                //答案正确
                if(answer.equals(map.get("answer").replace("|","").replace(" ",""))){
                    douleScore=douleScore+5;
                }
            }else if(map.get("questionType").equals("3")){  //判断题
                paramMap.put("id",map.get("questionId").trim());
                String answer=XMLUtil.getAnswer(paramMap);
                //答案正确
                if(answer.equals(map.get("answer").trim())){
                    judgeScore=judgeScore+5;
                }
            }else if(map.get("questionType").equals("4")){  //问答
//                System.out.println(filePath.indexOf("file"));
//                System.out.println(filePath.substring(0,filePath.indexOf("questionLibrary")));
                Map mapEssay=new HashMap();
                String essayFilePath=filePath.substring(0,filePath.indexOf("questionLibrary"))+"paperResult\\"+map.get("subject").trim()+"\\result.xml";
                System.out.println(essayFilePath);
                map.put("filePath",essayFilePath);
                map.put("studentId",account);
                map.put("paperId",map.get("examId"));
                map.put("answer",map.get("answer"));
                map.put("questionId",map.get("questionId"));
                XMLUtil.saveExamEssay(map);
            }
            mapScore.put("paperId",Integer.parseInt(map.get("examId")));
        }
        mapScore.put("singleScore",singleScore);
        mapScore.put("douleScore",douleScore);
        mapScore.put("judgeScore",judgeScore);
        mapScore.put("account",Integer.parseInt(account));

//        System.out.println(singleScore);
//        System.out.println(douleScore);
//        System.out.println(judgeScore);

        //将得分存放到数据库
         int flag=saveScore(mapScore);
        System.out.println(flag);
        return null;
    }

    //保存考试分数
    public Integer saveScore(Map map){
        return examPlanMapper.saveScore(map);
    }

    //增加考试记录
    public Integer insertExamRecord(Map map){
        return examPlanMapper.insertExamRecord(map);
    }

    //获取考试记录总数
    public Integer gerExamCount(){
        return examPlanMapper.getExamCount();
    }

    //根据学号和考试编号获取考试记录
    public ExamResult getExamRecordByStudentIdAndPaperId(Map map){
        return examPlanMapper.getExamRecordByStudentIdAndPaperId(map);
    }

    //根据教师工号获取考试安排信息
    public List<ExamPlan> getExamPlanByTeachId(Integer teacherId){
        return examPlanMapper.getExamPlanByTeachId(teacherId);
    }
}
