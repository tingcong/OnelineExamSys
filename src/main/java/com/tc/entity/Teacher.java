package com.tc.entity;

import java.io.Serializable;

/**
 * 教师实体
 * Created by TingCong on 2017/5/13.
 */
public class Teacher implements Serializable{

    //实体序列号
    private static final long serialVersionUID = -3606284611208028312L;

    //教师工号
    private Integer teacherId;

    //教师姓名
    private String teacherName;
}
