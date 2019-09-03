package net.will.rabbitmqhello;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.logs.name}", autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.name}", type = ExchangeTypes.TOPIC),
        key = "*.log.*"
))
public class AllLogReceiver {
    
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Got a log of all levels: " + msg);
    }
    
}
