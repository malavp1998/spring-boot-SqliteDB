package com.student.springWithSqlite.controller;


import com.student.springWithSqlite.model.Student;
import com.student.springWithSqlite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //@GetMapping("/readstudents")
    @RequestMapping(path = "readstudents",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> readStudents()
    {
       return new ResponseEntity<>(studentService.listStudent(), HttpStatus.OK);
    }

    @GetMapping("/readstudentsbyname")
    public List<Student> readStudentsByName(@RequestParam  String name)
    {
        return studentService.listStudentByName(name);
    }

    @GetMapping("/readstudentsbyrollnum")
    public ResponseEntity<List<Student>> get(@RequestParam  int rollNum)
    {
        return new ResponseEntity<>(studentService.listStudentByRollNum(rollNum),HttpStatus.OK);
    }

    @PostMapping("/createstudent")
    public ResponseEntity<String> createStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.OK);
    }


    @PutMapping("/updatestudent/{roll_num}/{name}")
    public ResponseEntity<String> updateStudent(@RequestParam Long id, @PathVariable int roll_num, @PathVariable String name)
    {
        if(studentService.editStudent(id, roll_num, name))
        {
            return  new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        }
        else
        {
            return  new ResponseEntity<>("Student could not be  updated, cause student with "+id+" not present in db", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        if(studentService.removeStudent(id))
        {
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Exception occured ! cannot delete the student ",HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.ACCEPTED);
    }

    /*
    @GetMapping("/getpathvariable/{id}/{name}")  // {for calling : http://localhost:8080/getpathvariable/43/piyush }
    public String getPathVariable(@PathVariable Integer id, @PathVariable String name)
    {
        return "got the variable+ "+ id + name;
    }
    */


}
