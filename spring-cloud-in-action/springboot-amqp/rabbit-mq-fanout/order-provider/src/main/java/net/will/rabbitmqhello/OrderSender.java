package net.will.rabbitmqhello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    @Value("${mq.config.exchange.name}")
    private String exchange;
    
    public void send() {
        String msg = "hello " + new Date();
        this.rabbitTemplate.convertAndSend(this.exchange, "", msg);
    }
}
