package net.will.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeskConfig {

    @Bean
    public Desk desk(){
        return new Desk();
    }
}
