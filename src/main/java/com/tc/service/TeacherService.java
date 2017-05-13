package com.tc.service;

import com.tc.entity.Teacher;
import com.tc.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TingCong on 2017/5/13.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /*根据教师工号获取教师信息*/
    public Teacher getTeacherInfoByID(Integer teacherId){
        return teacherMapper.getTeacherInfoByID(teacherId);
    }
}
