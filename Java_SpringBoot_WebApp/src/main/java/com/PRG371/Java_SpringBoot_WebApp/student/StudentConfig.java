//package com.PRG371.Java_SpringBoot_WebApp.student;
//
//import java.util.*;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class StudentConfig {
//    @Bean
//    CommandLineRunner cLR(StudentRepository repo)
//    {
//        return args ->
//        {
//            Student lyle = new Student(
//                    "Lyle",
//                    "4 Puk Street",
//                    "lyle@gmail.com",
//                    "curryPowder"
//            );
//
//            Student mmarona = new Student(
//                    "Mmarona",
//                    "10 Key Street",
//                    "mmarona@gmail.com",
//                    "girlPower"
//            );
//
//            repo.saveAll(
//                    List.of(lyle,mmarona)
//            );
//        };
//    }
//}

package com.PRG371.Java_SpringBoot_WebApp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner cLR(StudentRepository repo) {
        return args -> {
            if (repo.findStudentByEmail("lyle@gmail.com").isEmpty()) {
                Student lyle = new Student(
                        "Lyle",
                        "4 Puk Street",
                        "lyle@gmail.com",
                        "curryPowder"
                );
                repo.save(lyle);
            }

            if (repo.findStudentByEmail("mmarona@gmail.com").isEmpty()) {
                Student mmarona = new Student(
                        "Mmarona",
                        "10 Key Street",
                        "mmarona@gmail.com",
                        "girlPower"
                );
                repo.save(mmarona);
            }
        };
    }
}
