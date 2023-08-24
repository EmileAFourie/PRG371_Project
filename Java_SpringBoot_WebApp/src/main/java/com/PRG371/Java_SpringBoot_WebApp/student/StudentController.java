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
        return studentService.GetStudents();
    }

    @PostMapping
    public void RegisterStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Integer studentId)
    {
        studentService.DeleteStudent(studentId);
    }

    @PutMapping(path="{studentId}")
    public void UpdateStudent(@PathVariable("studentId") Integer studentId, @RequestParam(required = false) String name, @RequestParam(required = false) String email)
    {
        studentService.UpdateStudent(studentId, name, email);
    }
}
