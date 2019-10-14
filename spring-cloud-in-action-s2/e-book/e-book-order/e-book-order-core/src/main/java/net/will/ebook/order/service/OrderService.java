package net.will.ebook.order.service;

import net.will.ebook.order.domain.Order;
import net.will.ebook.order.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    
    public List<Order> findOrderByUserId(Integer userId) {
        return this.orderMapper.findOrderByUserId(userId);
    }
    
    public Integer createOrder(Order obj) {
        this.orderMapper.insert(obj);
        return obj.getId();
    }
    
    public void updateOrder(Order obj) {
        this.orderMapper.updateByPrimaryKey(obj);
    }
    
    public Order findOrderById(Integer id) {
        return this.orderMapper.selectByPrimaryKey(id);
    }
}
