package com.example.dao;

import java.util.List;
import com.example.model.CourseModel;
import com.example.model.StudentModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CourseMapper {

    @Select("select student.npm, name, gpa "+
            "from student join studentcourse "+
            "on studentcourse.npm = student.npm "+
            "where studentcourse.id_course = #{id_course}" )
    List<StudentModel> selectStudents(@Param("id_course") String id_course);

    @Select("select id_course, name, credits from course where id_course = #{id_course}")
    @Results(value = {
            @Result(property = "id_course", column = "id_course"),
            @Result(property = "name", column = "name"),
            @Result(property = "credits", column = "credits"),
            @Result(property = "students", column = "id_course",
            javaType = List.class,
            many = @Many(select = "selectStudents"))
    })
    CourseModel selectCourse (@Param("id_course") String id_course);

    @Select("select * from course")
    @Results(value = {
            @Result(property = "id_course", column = "id_course"),
            @Result(property = "students", column = "id_course",
                    javaType = List.class,
                    many = @Many(select = "selectStudents"))
    })
    List<CourseModel> selectAllCourses ();
}
