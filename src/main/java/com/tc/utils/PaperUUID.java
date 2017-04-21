package com.tc.utils;

import java.util.UUID;

/**
 * Created by 聪 on 2017/4/22.
 */
public class PaperUUID {
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    public static String getPaperUUID(){
        return getUUID().replaceAll("-","");
    }
    public static void main(String[] args) {
        System.out.println(getPaperUUID());
        System.out.println(getUUID());
    }
}
