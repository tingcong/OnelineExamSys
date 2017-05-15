package com.tc.mapper;

import com.tc.entity.Course;

import java.util.List;

/**
 * Created by htc on 2017/5/15.
 */
public interface CourseMapper {
    //获取所有课程名称放入下拉列表
    List<Course> getCourseInfoForSelect();
}
