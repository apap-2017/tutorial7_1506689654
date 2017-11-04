package com.example.dao;

import com.example.model.CourseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseDAO {

    CourseModel selectCourse(String id_course);
    List<CourseModel> selectAllCourses();

}
