package net.will.ebook.stream;

import net.will.ebook.product.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamGroupSenderApplication.class)
public class StreamGroupSenderApplicationTests {
    
    @Autowired
    private ISenderService senderService;
    
    @Test
    public void testSend() {
        Product obj = new Product();
        obj.setId(100);
        obj.setName("Spring Cloud");
        Message message = MessageBuilder.withPayload(obj).build();
        this.senderService.send().send(message);
    }
}
