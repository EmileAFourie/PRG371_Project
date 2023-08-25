package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student  s WHERE s.student_email = ?1")
    Optional<Student> findStudentByEmail(String email);
}