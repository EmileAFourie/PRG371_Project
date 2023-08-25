package com.PRG371.Java_SpringBoot_WebApp;

import java.util.*;

import com.PRG371.Java_SpringBoot_WebApp.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class JavaSpringBootWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootWebAppApplication.class, args);
	}


}


