package net.will.ebook.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("net.will.ebook.user.persistence")
public class EBookUserApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookUserApplication.class, args);
    }
    
}
