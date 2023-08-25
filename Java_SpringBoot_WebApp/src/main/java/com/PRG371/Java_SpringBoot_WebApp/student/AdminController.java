package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final StudentService studentService;

    @Autowired
    public AdminController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("students", studentService.getStudents()); // Changed to getStudents()
        return "admin"; // Thymeleaf template name
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id); // Assuming the method exists in StudentService
        model.addAttribute("student", student);
        return "edit_student"; // Thymeleaf template for editing
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student.getStudentName(), student.getStudentEmail()); // Changed to getStudentName() and getStudentEmail()
        return "redirect:/admin";
    }

    @PostMapping("/add") // Changed from @GetMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addNewStudent(student);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}") // Changed from @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/add")
    public String addStudent(@RequestParam String studentName,
                             @RequestParam String studentEmail,
                             @RequestParam String studentAddress) {
        Student newStudent = new Student(studentName, studentAddress, studentEmail, null); // Assuming you set the password later
        studentService.addNewStudent(newStudent);
        return "redirect:/admin"; // Redirect back to the admin page
    }
}