package net.will.ebook.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class EBookSymmetricEncryptionConfigServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EBookSymmetricEncryptionConfigServerApplication.class, args);
    }
    
}
