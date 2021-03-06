package net.will.ebook.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableEurekaClient
@SpringBootApplication
@EnableBinding({ISenderService.class})
public class StreamPartitionSenderApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StreamPartitionSenderApplication.class, args);
    }
    
}
