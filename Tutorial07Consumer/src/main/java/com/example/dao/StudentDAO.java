package com.example.dao;

import com.example.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentDAO {

    StudentModel selectStudent(String npm);
    List<StudentModel> selectAllStudents();

}
