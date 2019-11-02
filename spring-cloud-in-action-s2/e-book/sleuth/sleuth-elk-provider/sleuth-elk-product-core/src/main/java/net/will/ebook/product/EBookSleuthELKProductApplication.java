package net.will.ebook.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("net.will.ebook.product.persistence")
public class EBookSleuthELKProductApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookSleuthELKProductApplication.class, args);
    }
    
}
