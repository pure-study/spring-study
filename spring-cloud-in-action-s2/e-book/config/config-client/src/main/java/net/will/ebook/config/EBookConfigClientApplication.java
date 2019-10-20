package net.will.ebook.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EBookConfigClientApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookConfigClientApplication.class, args);
    }
    
}
