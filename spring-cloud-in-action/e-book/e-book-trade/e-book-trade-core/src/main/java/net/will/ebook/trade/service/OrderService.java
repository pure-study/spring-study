package net.will.ebook.trade.service;

import net.will.ebook.order.facade.OrderFacade;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "e-book-order")
public interface OrderService extends OrderFacade {
}
