package com.tc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取本地时间
 *
 * Created by htc on 2017/4/21.
 */
public class GetDatetimeUtil {

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

    public static void main(String[] args) {
        System.out.println(getLocalDatetime());

    }
}
