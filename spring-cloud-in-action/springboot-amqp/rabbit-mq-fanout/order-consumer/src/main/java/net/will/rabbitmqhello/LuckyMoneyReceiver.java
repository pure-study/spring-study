package net.will.rabbitmqhello;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.lucky.name}", autoDelete = "true"),
        exchange = @Exchange(value = "${mq.config.exchange.name}", type = ExchangeTypes.FANOUT)
))
public class LuckyMoneyReceiver {
    
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Handling lucky money: " + msg);
    }
    
}
