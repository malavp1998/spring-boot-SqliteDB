package com.student.springWithSqlite.service.impl;

import com.student.springWithSqlite.model.Student;
import com.student.springWithSqlite.repostitory.StudentRepository;
import com.student.springWithSqlite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepository studentrepository;

    public StudentServiceImpl(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    @Override
    public String saveStudent(Student student) {
        try
        {
            if(studentrepository.existsById(student.getId()) == true)
            {
                return "Student already present in DB";
            }
            studentrepository.save(student);
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
            return "Student created successfully";
    }


    @Override
    public List<Student> listStudent() {
       return studentrepository.findAll();
    }


    @Override
    public List<Student> listStudentByName(String name) {
         List<Student> list = studentrepository.findByName(name);
         return list;
    }

    @Override
    public List<Student> listStudentByRollNum(int rollNum) {
       return studentrepository.findByRollNum(rollNum);

    }

    @Override
    public boolean removeStudent(Long id) {
        try {
            studentrepository.deleteById(id);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean editStudent(Long id, int roll_num, String name) {
        try
        {
            if(studentrepository.existsById(id))
                throw new NullPointerException();
            studentrepository.deleteById(id);
        }
        catch (Exception e)
        {
            return false;
        }
        Student updatedStudent = new Student(id,roll_num,name);
        studentrepository.save(updatedStudent);
        return true;
    }
}
