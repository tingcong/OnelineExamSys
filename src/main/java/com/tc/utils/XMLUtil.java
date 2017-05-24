package com.tc.utils;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
     * @param path  文件路径
     * @param map   题目
     * @throws Exception
     */
    public static void addSimple(String path, Map map) throws Exception{
        SAXReader reader=new SAXReader();
        //读取题库文件
        Document doc=reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode=rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id",String.valueOf(id));

        Element titleNode=questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());

        Element choicesNode=questionNode.addElement("choices");
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
     * @param path
     * @param map
     * @throws Exception
     */
    public static void addMultip(String path, Map map) throws Exception{
        SAXReader reader=new SAXReader();
        //读取题库文件
        Document doc=reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode=rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id",String.valueOf(id));

        Element titleNode=questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());

        Element choicesNode=questionNode.addElement("choices");
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
     * @param path
     * @param map
     * @throws Exception
     */
    public static void addJudge(String path, Map map) throws Exception{
        SAXReader reader=new SAXReader();
        //读取题库文件
        Document doc=reader.read(path);
        //获取根节点
        Element rootNode = doc.getRootElement();
        //读取根节点的id属性获取题数
        Integer id = Integer.parseInt(doc.getRootElement().attributeValue("count")) + 1;
        //增加子节点
        Element questionNode=rootNode.addElement("question");
        //增加属性
        questionNode.addAttribute("id",String.valueOf(id));

        Element titleNode=questionNode.addElement("title");
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
        String path = "src/main/webapp/file/paperModel/";
        String fileName = "江西师大毕业考试";
//        createPaperModel(path+fileName+".xml");
        createPaperResultModel(path + fileName + "1310400114" + ".xml");
        System.out.println(path + fileName + ".xml");
    }

    public static void updatePaper(String path, Map map) throws Exception {
        if(Integer.parseInt(map.get("questionType").toString())==1){
            addSimple(path,map);
        }else if(Integer.parseInt(map.get("questionType").toString())==2){
            addMultip(path,map);
        }else if(Integer.parseInt(map.get("questionType").toString())==3){
            addJudge(path,map);
        }else if(Integer.parseInt(map.get("questionType").toString())==4){
            addEssay(path,map);
        }
    }
}
