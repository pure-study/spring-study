package net.will.rabbitmqhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqHelloApplication.class)
public class RabbitMqHelloApplicationTests {
    
    @Autowired
    private Sender sender;
    
    @Test
    public void testSend() throws InterruptedException {
        for (int i = 0; i < 60; i++) {
            this.sender.send();
            TimeUnit.SECONDS.sleep(1);
        }
    }
    
}
