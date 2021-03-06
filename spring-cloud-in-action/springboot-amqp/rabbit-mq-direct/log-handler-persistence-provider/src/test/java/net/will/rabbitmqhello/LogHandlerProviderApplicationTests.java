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
    public void testSendWithIndex() throws InterruptedException {
        for (int i = 0; i < 90; i++) {
            this.sender.send(i);
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
