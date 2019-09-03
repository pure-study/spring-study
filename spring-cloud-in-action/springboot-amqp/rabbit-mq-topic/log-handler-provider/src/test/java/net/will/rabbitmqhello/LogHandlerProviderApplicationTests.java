package net.will.rabbitmqhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogHandlerProviderApplication.class)
public class LogHandlerProviderApplicationTests {
    
    @Autowired
    private UserSender userSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private OrderSender orderSender;
    
    @Test
    public void testSend() throws InterruptedException {
        this.userSender.send();
        this.productSender.send();
        this.orderSender.send();
    }
}
