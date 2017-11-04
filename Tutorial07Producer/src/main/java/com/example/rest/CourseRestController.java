package com.example.rest;

import com.example.model.CourseModel;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CourseRestController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/course/view/{id_course}")
    public CourseModel view(@PathVariable(value = "id_course") String id_course){
        CourseModel course = courseService.selectCourse(id_course);
        return course;
    }
    @RequestMapping("/course/viewall")
    public List<CourseModel>  viewAll(){
        List<CourseModel> courses = courseService.selectAllCourses();
        return courses;
    }
}
