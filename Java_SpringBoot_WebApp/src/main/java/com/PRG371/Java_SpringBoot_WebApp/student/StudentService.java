package com.PRG371.Java_SpringBoot_WebApp.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> GetStudents()
    {
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email Taken.");
        }
        studentRepo.save(student);
    }

    public void DeleteStudent(Integer studentId) {
        boolean exists = studentRepo.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Student with ID: "+studentId+" does not exist.");
        }

        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void UpdateStudent(Integer studentId, String name, String email) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with ID: "+studentId+" does not exist."));
        boolean exists = studentRepo.existsById(studentId);

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }


        if(email!= null && email.length() > 0 && !Objects.equals(student.getEmail(), email))
        {
            Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("Email Taken.");
            }

            student.setEmail(email);
        }
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }
}
