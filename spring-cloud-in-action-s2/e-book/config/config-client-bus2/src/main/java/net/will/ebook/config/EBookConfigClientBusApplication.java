package net.will.ebook.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EBookConfigClientBusApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookConfigClientBusApplication.class, args);
    }
    
}
