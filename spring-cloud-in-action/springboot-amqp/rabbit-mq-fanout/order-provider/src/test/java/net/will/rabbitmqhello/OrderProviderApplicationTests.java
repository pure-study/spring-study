package net.will.rabbitmqhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderProviderApplication.class)
public class OrderProviderApplicationTests {
    
    @Autowired
    private OrderSender orderSender;
    
    @Test
    public void testSend() {
        this.orderSender.send();
    }
}
