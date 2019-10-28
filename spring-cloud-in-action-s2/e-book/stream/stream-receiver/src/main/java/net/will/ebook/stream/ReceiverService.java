package net.will.ebook.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({IReceiverService.class})
public class ReceiverService {
    @StreamListener("will-exchange")
    public void onReceive(byte[] msg) {
        System.out.println("receive: " + new String(msg));
    }
}
