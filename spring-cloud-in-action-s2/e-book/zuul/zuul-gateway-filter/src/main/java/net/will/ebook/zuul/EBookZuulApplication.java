package net.will.ebook.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class EBookZuulApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookZuulApplication.class, args);
    }
    
}
