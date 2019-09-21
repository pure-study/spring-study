package net.will.eureka.consumer;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumerApplication {
    
/*    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }*/
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
    
}
