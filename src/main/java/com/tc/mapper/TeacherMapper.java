package com.tc.mapper;

import com.tc.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by TingCong on 2017/5/13.
 */
public interface TeacherMapper {

    //根据教师工号获取教师信息
    Teacher getTeacherInfoByID(@Param("teacherId") int teacherId);

    //获取所有的教师信息放入select中
    List<Teacher> getTeacherInfoForSelect();
}
