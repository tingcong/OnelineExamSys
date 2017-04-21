package com.tc.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *  操作XML文件的工具类
 *
 * Created by htc on 2017/4/21.
 */
public class XMLUtil {
    public static void createXMLFile(String path) throws Exception {
        Document doc= DocumentHelper.createDocument();

    //指定输出路径
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        //指定文件格式
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        //设置编码
        outputFormat.setEncoding("UTF-8");

        XMLWriter writer=new XMLWriter(fileOutputStream,outputFormat);

        writer.write(doc);
        writer.close();
    }

    public static void main(String[] args) throws Exception{
        String path="src/main/webapp/file/paperModel/";
        String fileName="江西师大毕业考试";
        createXMLFile(path+fileName+".xml");
    }
}
