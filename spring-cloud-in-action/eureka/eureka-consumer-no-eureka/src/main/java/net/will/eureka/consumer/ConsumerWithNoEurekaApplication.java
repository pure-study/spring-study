package net.will.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerWithNoEurekaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumerWithNoEurekaApplication.class, args);
    }
    
}
