package net.will.ebook.order.facade;

import net.will.ebook.order.domain.Order;
import net.will.ebook.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;
    
    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        return this.orderService.findOrderByUserId(userId);
    }
    
    @Override
    public Integer createOrder(@RequestBody Order obj) {
        return this.orderService.createOrder(obj);
    }
    
    @Override
    public void updateOrder(@RequestBody Order obj) {
        this.orderService.updateOrder(obj);
    }
    
    @Override
    public Order findOrderById(Integer id) {
        return this.orderService.findOrderById(id);
    }
}
