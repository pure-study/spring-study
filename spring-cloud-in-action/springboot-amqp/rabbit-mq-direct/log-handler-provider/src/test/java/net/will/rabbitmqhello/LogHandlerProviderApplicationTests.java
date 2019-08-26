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
    private Sender sender;
    
    @Test
    public void testSendInLoop() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0) {
                this.sender.sendLogWithRoutingKey("log.error.routing.key");
            } else {
                this.sender.sendInfoLog();
            }
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
    
    @Test
    public void testSendInfo() {
        this.sender.sendInfoLog();
    }
    
    @Test
    public void testSendError() {
        this.sender.sendLogWithRoutingKey("log.error.routing.key");
    }
    
}
