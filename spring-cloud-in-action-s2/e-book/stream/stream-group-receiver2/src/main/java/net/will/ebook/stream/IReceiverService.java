package net.will.ebook.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiverService {
    final String INPUT = "inputProduct";

    @Input(INPUT)
    SubscribableChannel receive();
}
