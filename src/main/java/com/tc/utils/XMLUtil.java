package com.tc.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 操作XML文件的工具类
 * <p>
 * Created by htc on 2017/4/21.
 */
public class XMLUtil {

    /**
     * 生成试卷模板
     * src/main/webapp/file/paperModel/江西师大毕业考试.xml
     *
     * @param path 文件路径
     * @throws Exception
     */
    public static void createPaperModel(String path) throws Exception {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("文件已存在，请重新输入文件名");
        } else {
            Document doc = DocumentHelper.createDocument();

            //生成试卷
            Element rootElem = doc.addElement("paper");
            //试卷头
            Element headElem = rootElem.addElement("head");
            headElem.addElement("id");
            headElem.addElement("tittle");
            headElem.addElement("score");
            headElem.addElement("author");
            headElem.addElement("limitTime");
            //试卷体
            Element bodyElem = rootElem.addElement("body");
            bodyElem.addElement("singleChoiceQuestions");
            bodyElem.addElement("multipleChoiceQuestions");
            bodyElem.addElement("clozes");
            bodyElem.addElement("judgmentQuestions");
            bodyElem.addElement("essayQuestions");

            //指定输出路径
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            //指定文件格式
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            //设置编码
            outputFormat.setEncoding("UTF-8");

            XMLWriter writer = new XMLWriter(fileOutputStream, outputFormat);
            writer.write(doc);
            writer.close();
        }
    }


    /**
     * 生成结果卷模板
     *
     * @param path 文件路径
     * @throws Exception
     */
    public static void createPaperResultModel(String path) throws Exception {
        Document doc = DocumentHelper.createDocument();

        Element rootElem = doc.addElement("paperResult");
        Element headElem = rootElem.addElement("head");
        headElem.addElement("id");
        headElem.addElement("yourScore");
        headElem.addElement("teacher");
        Element body = rootElem.addElement("body");

        FileOutputStream ou = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        XMLWriter writer = new XMLWriter(ou, format);
        writer.write(doc);
        writer.close();

    }

    public static String getProjectRealPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 更新单选题
     *
     * @param path 文件路径
     * @param map  题目
     * @throws Exception
     */
    public static void addSimple(String path, Map map) throws Exception {
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc = reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode = rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id", String.valueOf(id));

        Element titleNode = questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());

        Element choicesNode = questionNode.addElement("choices");
        choicesNode.addElement("A").setText(map.get("A").toString());
        choicesNode.addElement("B").setText(map.get("B").toString());
        choicesNode.addElement("C").setText(map.get("C").toString());
        choicesNode.addElement("D").setText(map.get("D").toString());

        questionNode.addElement("answer").setText(map.get("answer").toString());

        //总题数+1
        doc.getRootElement().attribute("count").setValue(String.valueOf(id));
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();

    }

    /**
     * 跟新多选题
     *
     * @param path
     * @param map
     * @throws Exception
     */
    public static void addMultip(String path, Map map) throws Exception {
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc = reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode = rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id", String.valueOf(id));

        Element titleNode = questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());

        Element choicesNode = questionNode.addElement("choices");
        choicesNode.addElement("A").setText(map.get("A").toString());
        choicesNode.addElement("B").setText(map.get("B").toString());
        choicesNode.addElement("C").setText(map.get("C").toString());
        choicesNode.addElement("D").setText(map.get("D").toString());

        questionNode.addElement("answer").setText(map.get("answer").toString());

        //总题数+1
        doc.getRootElement().attribute("count").setValue(String.valueOf(id));
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();

    }

    /**
     * 跟新判断题
     *
     * @param path
     * @param map
     * @throws Exception
     */
    public static void addJudge(String path, Map map) throws Exception {
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc = reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode = rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id", String.valueOf(id));

        Element titleNode = questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());

        questionNode.addElement("answer").setText(map.get("answer").toString());

        //总题数+1
        doc.getRootElement().attribute("count").setValue(String.valueOf(id));
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();

    }

    /**
     * 更新问答题题库
     *
     * @param map 需要跟新的数据
     */
    public static void addEssay(String path, Map map) throws Exception {
        //String path="/src/main/webapp/file/questionLibrary/"+map.get("subject")+"/"+map.get("questionType")+"-"+map.get("level")+".xml";

        //String path="C:\\Users\\TingCong\\IdeaProjects\\OnelineExamSysamSys\\src\\main\\webapp\\file\\questionLibrary\\1\\1-c.xml";
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc = reader.read(path);
        //        System.out.println(doc);
        //获取根节点
        Element rootNode = doc.getRootElement();
/*
        //遍历某节点的所有属性
        List<Attribute> attributes=rootNode.attributes();
        for(Attribute attr:attributes){//遍历当前节点的所有属性
            String name=attr.getName();//属性名称
            String value=attr.getValue();//属性的值
            System.out.println("属性名称："+name+"属性值："+value);
        }
        */
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加question节点
        Element questionNode = rootNode.addElement("question");
        //为question节点增加ID属性，即题号
        questionNode.addAttribute("id", String.valueOf(id));
        //增加title节点
        Element titleNode = questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());
        //增加answer节点
        Element answerNode = questionNode.addElement("answer");
        answerNode.setText(map.get("answer").toString());

        //总题数+1
        doc.getRootElement().attribute("count").setValue(String.valueOf(id));
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
/*        String path = "src/main/webapp/file/paperModel/";
        String fileName = "江西师大毕业考试";
//        createPaperModel(path+fileName+".xml");
        createPaperResultModel(path + fileName + "1310400114" + ".xml");
        System.out.println(path + fileName + ".xml");*/
        Random random = new Random(10);
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() < 5) {
            int s = random.nextInt(10);
            randomSet.add(s);
            System.out.println(randomSet.size());
        }
        Iterator<Integer> it = randomSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void updatePaper(String path, Map map) throws Exception {
        if (Integer.parseInt(map.get("questionType").toString()) == 1) {
            addSimple(path, map);
        } else if (Integer.parseInt(map.get("questionType").toString()) == 2) {
            addMultip(path, map);
        } else if (Integer.parseInt(map.get("questionType").toString()) == 3) {
            addJudge(path, map);
        } else if (Integer.parseInt(map.get("questionType").toString()) == 4) {
            addEssay(path, map);
        }
    }

    /**
     * 获取各个题型的总数
     *
     * @return
     */
    public static Integer getTotal(String path) throws Exception {
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc = reader.read(path);
        Element rootNode = doc.getRootElement();
//        String count=rootNode.attribute("count").getText();
//        System.out.println("count"+count);
        return Integer.parseInt(rootNode.attribute("count").getText());
    }

    /**
     * 获取多个随机数
     *
     * @param max
     * @param n
     * @return
     */
    public static Set<Integer> getRandom(int max, int n) {
        Random random = new Random(max);
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size() < n) {
            int s = random.nextInt(max);
            if (s != 0) {
                randomSet.add(s);
            }
            System.out.println(randomSet.size());
        }
        return randomSet;
    }

    /**
     * 根据题号获取x选择题题目信息
     *
     * @param questionNum
     * @return
     */
    public static Map<String, Object> getSingleDetail(int questionNum, String path) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        Element rootNode = doc.getRootElement();
        //获取根节点下的所有子节点
        List<Element> elements = rootNode.elements();
        Map<String, Object> singleDetailMap = new HashMap<>();
        for (Element ele : elements) {
            Element element = ele;
//            System.out.println(ele.attribute("id").getText() + " : " + ele.attribute("id").getText().getClass() + "  " + s.getClass());
            if (ele.attribute("id").getText().equals(String.valueOf(questionNum))) {
                //文件路径
                singleDetailMap.put("filePath", path);
                //题号
                singleDetailMap.put("questionId", ele.attribute("id").getText());
                //问题
                singleDetailMap.put("title", ele.element("title").getText());
                //选项
                singleDetailMap.put("A", ele.element("choices").element("A").getText());
                singleDetailMap.put("B", ele.element("choices").element("B").getText());
                singleDetailMap.put("C", ele.element("choices").element("C").getText());
                singleDetailMap.put("D", ele.element("choices").element("D").getText());
                //答案
                singleDetailMap.put("answer", ele.element("answer").getText());
            }
        }
        return singleDetailMap;
    }

    /**
     * 获取判断题信息
     *
     * @param questionNum
     * @param path
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getJudgmenDetail(int questionNum, String path) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        Element rootNode = doc.getRootElement();
        //获取根节点下的所有子节点
        List<Element> elements = rootNode.elements();
        Map<String, Object> singleDetailMap = new HashMap<>();
        for (Element ele : elements) {
            Element element = ele;
//            System.out.println(ele.attribute("id").getText() + " : " + ele.attribute("id").getText().getClass() + "  " + s.getClass());
            if (ele.attribute("id").getText().equals(String.valueOf(questionNum))) {
                //文件路径
                singleDetailMap.put("filePath", path);
                //题号
                singleDetailMap.put("questionId", ele.attribute("id").getText());
                //问题
                singleDetailMap.put("title", ele.element("title").getText());
                //答案
                singleDetailMap.put("answer", ele.element("answer").getText());
                singleDetailMap.put("type", "Judgment");
            }
        }
        return singleDetailMap;
    }

    /**
     * 获取问答题信息
     *
     * @param questionNum
     * @param path
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getEssayDetail(int questionNum, String path) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        Element rootNode = doc.getRootElement();
        //获取根节点下的所有子节点
        List<Element> elements = rootNode.elements();
        Map<String, Object> singleDetailMap = new HashMap<>();
        for (Element ele : elements) {
            Element element = ele;
//            System.out.println(ele.attribute("id").getText() + " : " + ele.attribute("id").getText().getClass() + "  " + s.getClass());
            if (ele.attribute("id").getText().equals(String.valueOf(questionNum))) {
                //文件路径
                singleDetailMap.put("filePath", path);
                //题号
                singleDetailMap.put("questionId", ele.attribute("id").getText());
                //问题
                singleDetailMap.put("title", ele.element("title").getText());
                //答案
                singleDetailMap.put("answer", ele.element("answer").getText());
                singleDetailMap.put("type", "Essay");
            }
        }
        return singleDetailMap;
    }

    /**
     * 根据文件路径和题号获取答案
     *
     * @param map 封装文件路径和题号参数
     * @return
     */
    public static String getAnswer(Map map) throws Exception {
        SAXReader reader = new SAXReader();
        System.out.println(map.get("filePath").toString());
        Document doc = reader.read(map.get("filePath").toString());
        Element rootNode = doc.getRootElement();
        List<Element> elements = rootNode.elements();
        for (Element ele : elements) {
            if (ele.attribute("id").getText().trim().equals(map.get("id"))) {
                return ele.element("answer").getText().trim();
            }
        }
        return "ERROR";
    }


    public static void saveExamEssay(Map map) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(map.get("filePath").toString());
        Element rootNode = doc.getRootElement();
        Element element = rootNode.addElement("result");
        element.addAttribute("paper_id", map.get("paperId").toString().trim());
        element.addAttribute("question_id", map.get("questionId").toString().trim());
        element.addAttribute("student_id", map.get("studentId").toString().trim());
        element.addElement("student-answer").addText(map.get("answer").toString());
        element.addElement("isRead").addText("F");

        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(map.get("filePath").toString());
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();
    }

    /**
     * 根据考试编号获取没有批改的试卷
     *
     * @param
     * @return
     */
    public static List<Map> getNotCorrection(Map map) throws Exception {
        //存放返回的结果
        List<Map> mapList = new ArrayList<>();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(map.get("filePath").toString());
        Element rootNode = doc.getRootElement();
        List<Element> elements = rootNode.elements();
        for (Element ele : elements) {
            //找到对应的考试编号并且标记状态 未未读“F"
            Map resultMap = new HashMap();
//            System.out.println("paper_id: "+ele.attribute("paper_id").getText().getClass());
//            System.out.println("examId:"+map.get("examId").toString().getClass());
            if (ele.attribute("paper_id").getText().equals(map.get("examId").toString()) && ele.element("isRead").getText().equals("F")) {
                resultMap.put("paperId", ele.attribute("paper_id").getText());
                resultMap.put("studentId", ele.attribute("student_id").getText());
                resultMap.put("questionId", ele.attribute("question_id").getText());
                resultMap.put("studentAnswer", ele.element("student-answer").getText());
//                ele.element("isRead").setText("T");
                String question = getQuestionByquestionIdAndSubjectId(resultMap.get("questionId").toString(), map.get("filePath").toString().trim());
                if (question != null) {
                    resultMap.put("title", question);
                }
                mapList.add(resultMap);
            }
        }

        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(map.get("filePath").toString());
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();
        return mapList;
    }


    public static String getQuestionByquestionIdAndSubjectId(String questionId, String filePath) throws Exception {
        String path = filePath.replace("paperResult", "questionLibrary").replace("result.xml", "4-1.xml");
//        System.out.println(path);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        Element rootNode = doc.getRootElement();
        List<Element> elements = rootNode.elements();
        for (Element ele : elements) {
            if (ele.attribute("id").getText().trim().equals(questionId.trim())) {
                return ele.element("title").getText();
            }
        }
        return null;
    }

    public static void updateEssayResultStatus(String filePath, String quetionId, String paperId) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(filePath);
//        Document doc=reader.read( "C:\\Users\\TingCong\\IdeaProjects\\OnelineExamSys\\src\\main\\webapp\\file\\paperResult\\6\result.xml");
        Element rootNode = doc.getRootElement();
        List<Element> elements = rootNode.elements();
        for (Element ele : elements) {
            if (ele.attribute("paper_id").getText().trim().equals(paperId) && ele.attribute("question_id").getText().equals(quetionId)) {
                ele.element("isRead").setText("T");
            }
        }
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream = new FileOutputStream(filePath);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream, format);
        writer.write(doc);
        writer.close();
    }
}
