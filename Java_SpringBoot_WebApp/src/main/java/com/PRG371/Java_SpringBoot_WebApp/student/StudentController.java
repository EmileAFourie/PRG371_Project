package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> GetStudents()
    {
        return studentService.getStudents();
    }

    @PostMapping
    public void RegisterStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Integer studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student.getStudentName(), student.getStudentEmail(), student.getStudentAddress(), student.getStudentPassword());
        return "redirect:/admin";
    }





}
