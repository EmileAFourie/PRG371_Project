package com.PRG371.Java_SpringBoot_WebApp.student;

//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "student")
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
//    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
//    @Column(name = "student_id")
//    private int studentId;
//
//    @Column(name = "student_name")
//    private String studentName;
//
//    @Column(name = "student_address")
//    private String studentAddress;
//
//    @Column(name = "student_email", unique = true)
//    private String studentEmail;
//
//    @Column(name = "student_password")
//    private String studentPassword;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_address")
    private String studentAddress;

    @Column(name = "student_email", unique = true)
    private String studentEmail;

    @Column(name = "student_password")
    private String studentPassword;



    // Constructors
        public Student() {
        }

        public Student(String studentName, String studentAddress, String studentEmail, String studentPassword) {
            this.studentName = studentName;
            this.studentAddress = studentAddress;
            this.studentEmail = studentEmail;
            this.studentPassword = studentPassword;
        }

        // Getter and Setter methods
        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentAddress() {
            return studentAddress;
        }

        public void setStudentAddress(String studentAddress) {
            this.studentAddress = studentAddress;
        }

        public String getStudentEmail() {
            return studentEmail;
        }

        public void setStudentEmail(String studentEmail) {
            this.studentEmail = studentEmail;
        }

        public String getStudentPassword() {
            return studentPassword;
        }

        public void setStudentPassword(String studentPassword) {
            this.studentPassword = studentPassword;
        }

        // Other methods...

//        @Override
//        public String toString() {
//            return "Student{" +
//                    "id=" + studentId +
//                    ", name='" + studentName + '\'' +
//                    ", address='" + studentAddress + '\'' +
//                    ", email='" + studentEmail + '\'' +
//                    ", password='" + studentPassword + '\'' +
//                    '}';
//        }
        @Override
        public String toString() {
            return "Student{" +
                    "studentId=" + studentId +
                    ", studentName='" + studentName + '\'' +
                    ", studentAddress='" + studentAddress + '\'' +
                    ", studentEmail='" + studentEmail + '\'' +
                    ", studentPassword='" + studentPassword + '\'' +
                    '}';
        }
    }