package net.will.ebook.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EbookProductApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EbookProductApplication.class, args);
    }
    
}
