package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    public AdminController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String adminPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "admin";
    }

    @PostMapping("/edit/{id}")
    public String updateStudentForm(@PathVariable int id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student.getStudentName(), student.getStudentEmail(), student.getStudentAddress(), student.getStudentPassword());
        return "redirect:/admin";
    }


    @PostMapping("/update/{studentId}")
    public ResponseEntity<String> updateStudent(
            @PathVariable Integer studentId,
            @RequestBody Student updatedStudent
    ) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        student.setStudentName(updatedStudent.getStudentName());
        student.setStudentEmail(updatedStudent.getStudentEmail());
        student.setStudentAddress(updatedStudent.getStudentAddress());
        studentRepository.save(student);

        return ResponseEntity.ok("Student updated successfully");
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.ok("Student deleted successfully");
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully");
        } catch (Exception e) {
            logger.error("An error occurred while deleting student with ID: " + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting student.");
        }
    }



    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addNewStudent(student);
        return "redirect:/admin";
    }

    @PostMapping("/admin/add")
    public String addStudent(@RequestParam String studentName,
                             @RequestParam String studentEmail,
                             @RequestParam String studentAddress) {
        Student newStudent = new Student(studentName, studentAddress, studentEmail, null); // Assuming you set the password later
        studentService.addNewStudent(newStudent);
        return "redirect:/admin";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String term) {
        List<Student> searchResults = studentService.searchStudents(term);
        return ResponseEntity.ok(searchResults);
    }



    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}