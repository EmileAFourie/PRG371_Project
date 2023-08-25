package com.PRG371.Java_SpringBoot_WebApp.controllers;

import com.PRG371.Java_SpringBoot_WebApp.student.Student;
import com.PRG371.Java_SpringBoot_WebApp.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final StudentRepository repo;

    @Autowired
    public LoginController(StudentRepository studentRepository) {
        this.repo = studentRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the name of your login HTML page
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email) {
        // Retrieve the student by email
        Student student = repo.findStudentByEmail(email).orElse(null);

        if (student != null) {
            return "redirect:/dashboard"; // Redirect to dashboard page on successful login
        } else {
            return "redirect:/login?error"; // Redirect to login page with an error parameter
        }
    }
}
