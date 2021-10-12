package com.student.springWithSqlite.service;

import com.student.springWithSqlite.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {


    public String saveStudent(Student student);

    public List<Student> listStudent();

    public boolean removeStudent(Long id);

    public boolean editStudent(Long id, int roll_num, String name);

    public List<Student> listStudentByName(String name);

    public List<Student> listStudentByRollNum(int rollNum);


}
