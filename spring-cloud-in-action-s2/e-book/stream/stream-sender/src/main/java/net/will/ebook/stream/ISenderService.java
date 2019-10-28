package net.will.ebook.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISenderService {

    @Output("will-exchange")
    SubscribableChannel send();
}
