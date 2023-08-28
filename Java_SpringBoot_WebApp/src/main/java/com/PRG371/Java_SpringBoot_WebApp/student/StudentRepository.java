package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Optional;

//@Repository
//public interface StudentRepository extends JpaRepository<Student, Integer> {
//    @Query("SELECT s FROM Student s WHERE s.studentEmail = ?1")
//
//    Optional<Student> findStudentByEmail(String email);
//
//
//
//}

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE lower(s.studentName) LIKE lower(concat('%', ?1, '%'))")
    List<Student> findByStudentNameContainingIgnoreCase(String name);

    Optional<Student> findStudentByEmail(String email);
}



