package net.will.ebook.order.facade;

import net.will.ebook.order.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/order")
public interface OrderFacade {
    @RequestMapping(value = "/findOrderByUserId", method = RequestMethod.GET)
    public List<Order> findOrderByUserId(@RequestParam("userId") Integer userId);
    
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Integer createOrder(@RequestBody Order obj);
    
    @RequestMapping(value = "/updateOrderByTrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrder(@RequestBody Order obj);
    
    @RequestMapping(value = "/findOrderById", method = RequestMethod.GET)
    public Order findOrderById(@RequestParam("id") Integer id);
}
