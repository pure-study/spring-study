package net.will.ebook.stream;

import net.will.ebook.product.domain.Product;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({IReceiverService.class})
public class ReceiverService {
    @StreamListener(IReceiverService.INPUT)
    public void onReceive(Product obj) {
        System.out.println("receive: " + obj.toString());
    }
}
