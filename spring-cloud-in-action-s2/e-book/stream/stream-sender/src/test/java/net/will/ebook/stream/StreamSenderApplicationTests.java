package net.will.ebook.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamSenderApplication.class)
public class StreamSenderApplicationTests {
    
    @Autowired
    private ISenderService senderService;
    
    @Test
    public void testSend() {
        String rawMsg = "Will's message...............";
        Message message = MessageBuilder.withPayload(rawMsg.getBytes()).build();
        this.senderService.send().send(message);
    }
}
