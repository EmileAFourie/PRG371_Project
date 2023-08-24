package com.PRG371.Java_SpringBoot_WebApp.student;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int student_id;
    private String student_name;
    private  String student_address;
    private String student_email;
    private String student_password;

    public int getId() {
        return student_id;
    }

    public void setId(int id) {
        this.student_id = id;
    }

    public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public String getAddress() {
        return student_address;
    }

    public void setAddress(String address) {
        this.student_address = address;
    }

    public String getEmail() {
        return student_email;
    }

    public void setEmail(String email) {
        this.student_email = email;
    }

    public String getPassword() {
        return student_password;
    }

    public void setPassword(String password) {
        this.student_password = password;
    }

    public Student() {
    }

    public Student(int id, String name, String address, String email, String password) {

        this.student_id = id;
        this.student_name = name;
        this.student_address = address;
        this.student_email = email;
        this.student_password = password;
    }

    public Student(String name, String address, String email, String password) {
        this.student_name = name;
        this.student_address = address;
        this.student_email = email;
        this.student_password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + student_id +
                ", name='" + student_name + '\'' +
                ", address='" + student_address + '\'' +
                ", email='" + student_email + '\'' +
                ", password='" + student_password + '\'' +
                '}';
    }
}
