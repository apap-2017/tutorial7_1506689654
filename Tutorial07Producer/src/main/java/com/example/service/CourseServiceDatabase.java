package com.example.service;
import com.example.dao.CourseMapper;
import com.example.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j

@Service
public class CourseServiceDatabase implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseModel selectCourse (String id_course)
    {
        log.info ("select course with id_course {}", id_course);
        return courseMapper.selectCourse (id_course);
    }
    @Override
    public List<CourseModel> selectAllCourses ()
    {
        return courseMapper.selectAllCourses();
    }

}
