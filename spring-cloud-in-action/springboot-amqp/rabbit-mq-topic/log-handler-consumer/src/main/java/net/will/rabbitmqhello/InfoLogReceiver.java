package net.will.rabbitmqhello;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.info.name}", autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.name}", type = ExchangeTypes.TOPIC),
        key = "*.log.info"
))
public class InfoLogReceiver {
    
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Got an INFO log: " + msg);
    }
    
}
