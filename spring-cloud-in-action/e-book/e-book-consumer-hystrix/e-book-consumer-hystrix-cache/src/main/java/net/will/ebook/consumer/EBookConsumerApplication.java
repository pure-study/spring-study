package net.will.ebook.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableCaching
@EnableEurekaClient
@SpringBootApplication
public class EBookConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookConsumerApplication.class, args);
    }
    
}
