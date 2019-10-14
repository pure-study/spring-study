package net.will.ebook.trade.service;

import net.will.ebook.trade.domain.Trade;
import net.will.ebook.trade.persistence.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    private TradeMapper tradeMapper;
    
    public void createTrade(Trade obj) {
        this.tradeMapper.insert(obj);
    }
}
