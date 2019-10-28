package net.will.ebook.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableEurekaClient
@SpringBootApplication
@EnableBinding({IReceiverService.class})
public class StreamGroupReceiverApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StreamGroupReceiverApplication.class, args);
    }
    
}
