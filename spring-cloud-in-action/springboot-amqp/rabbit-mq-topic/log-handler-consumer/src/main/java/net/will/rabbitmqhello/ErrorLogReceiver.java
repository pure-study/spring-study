package net.will.rabbitmqhello;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.error.name}", autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.name}", type = ExchangeTypes.TOPIC),
        key = "*.log.error"
))
public class ErrorLogReceiver {
    
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Got an ERROR log: " + msg);
    }
    
}
