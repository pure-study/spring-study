package net.will.ebook.consumer.service;

import net.will.ebook.trade.facade.TradeFacade;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "e-book-trade")
public interface TradeService extends TradeFacade {
}
