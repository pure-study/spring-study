package net.will.ebook.trade;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@MapperScan("net.will.ebook.trade.persistence")
public class EBookTradeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookTradeApplication.class, args);
    }
    
}
