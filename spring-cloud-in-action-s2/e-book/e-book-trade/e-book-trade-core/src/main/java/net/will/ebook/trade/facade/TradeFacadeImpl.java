package net.will.ebook.trade.facade;

import net.will.ebook.order.domain.Order;
import net.will.ebook.trade.domain.Trade;
import net.will.ebook.trade.service.OrderService;
import net.will.ebook.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeFacadeImpl implements TradeFacade {
    @Autowired
    private TradeService tradeService;
    
    @Autowired
    private OrderService orderService;
    
    @Override
    public void createTrade(@RequestBody Trade obj) {
        System.out.println("order_id in Trade before insert: " + obj.getOrderId());
        this.tradeService.createTrade(obj);
        
        Order order = this.orderService.findOrderById(obj.getOrderId());
        order.setTradeId(obj.getId());
        order.setTradeStatus(true);
        this.orderService.updateOrder(order);
    }
}
