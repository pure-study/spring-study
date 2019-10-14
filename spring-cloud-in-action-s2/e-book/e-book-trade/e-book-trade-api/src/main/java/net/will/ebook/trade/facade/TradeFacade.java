package net.will.ebook.trade.facade;

import net.will.ebook.trade.domain.Trade;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/trade")
public interface TradeFacade {
    
    @RequestMapping(value = "/createTrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTrade(Trade obj);
}
