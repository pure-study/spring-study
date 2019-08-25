package net.will.rabbitmqhello;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    
    @RabbitListener(queues = "hello-will-queue")
    public void process(String msg) {
        System.out.println("Receiver: " + msg);
    }
}
