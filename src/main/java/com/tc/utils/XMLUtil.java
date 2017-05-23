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
     * @param path  文件路径
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
     * @param path  文件路径
     * @throws Exception
     */
    public static void createPaperResultModel(String path) throws Exception {
        Document doc=DocumentHelper.createDocument();

        Element rootElem=doc.addElement("paperResult");
        Element headElem=rootElem.addElement("head");
        headElem.addElement("id");
        headElem.addElement("yourScore");
        headElem.addElement("teacher");
        Element body=rootElem.addElement("body");

        FileOutputStream ou=new FileOutputStream(path);
        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");

        XMLWriter writer=new XMLWriter(ou,format);
        writer.write(doc);
        writer.close();

    }
    public static String getProjectRealPath(){
        return System.getProperty("user.dir");
    }

    /**
     * 更新题库
     * @param map 需要跟新的数据
     */
    public static void updatePaper(String path,Map map) throws DocumentException, IOException {
        //String path="/src/main/webapp/file/questionLibrary/"+map.get("subject")+"/"+map.get("questionType")+"-"+map.get("level")+".xml";

        //String path="C:\\Users\\TingCong\\IdeaProjects\\OnelineExamSysamSys\\src\\main\\webapp\\file\\questionLibrary\\1\\1-c.xml";
        SAXReader reader = new SAXReader();
        //读取题库文件
        Document doc=reader.read(path);
        //        System.out.println(doc);
        //读取根节点的id属性获取题数
        Integer id=Integer.parseInt(doc.getRootElement().element("questions").attributeValue("id"))+1;
        //增加question节点
        Element questionNode=doc.addElement("question");
        //为question节点增加ID属性，即题号
        questionNode.addAttribute("id",String.valueOf(id));
        //增加title节点
        Element titleNode=questionNode.addElement("title");
        titleNode.setText(map.get("title").toString());
        //增加answer节点
        Element answerNode=questionNode.addElement("answer");
        answerNode.setText(map.get("answer").toString());
        //将修改过后的对象写出到预原题库文件
        FileOutputStream outputStream=new FileOutputStream(path);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream,format);
        writer.write(doc);
        writer.close();
    }
    public static void main(String[] args) throws Exception {
        String path = "src/main/webapp/file/paperModel/";
        String fileName = "江西师大毕业考试";
//        createPaperModel(path+fileName+".xml");
        createPaperResultModel(path+fileName+"1310400114"+".xml");
        System.out.println(path + fileName + ".xml");
    }
}
