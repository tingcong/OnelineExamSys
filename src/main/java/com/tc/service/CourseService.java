package com.tc.service;

import com.tc.entity.Course;
import com.tc.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by htc on 2017/5/15.
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    /*    获取所有课程名称放入下拉列表  */
    public List<Course> getCourseInfoForSelect(){
        return courseMapper.getCourseInfoForSelect();
    }
}
