package com.tc.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取本地时间
 *
 * Created by htc on 2017/4/21.
 */
public class DatetimeUtil {

    /**
     * Java时间设为二十四小时制和十二小时制的区别：
     1） 二十四小时制： “yyyy-MM-dd HH:mm:ss”
     2）十二小时制： “"yyyy-MM-dd hh:mm:ss"”
     * @return
     * @throws Exception
     */
    public static String getLocalDatetime() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static void getMinutes(String start, String end) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition parsePosition=new ParsePosition(1);
        System.out.println( format.parse(start,parsePosition));
    }

    public static void main(String[] args) throws ParseException {
        getMinutes("2020-04-25 01:42:28.00000","22020-04-25 03:42:28.00000");
    }
}
