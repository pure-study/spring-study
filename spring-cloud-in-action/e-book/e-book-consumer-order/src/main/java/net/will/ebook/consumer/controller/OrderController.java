package net.will.ebook.consumer.controller;

import net.will.ebook.consumer.service.OrderService;
import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.consumer.service.TradeService;
import net.will.ebook.consumer.service.UserService;
import net.will.ebook.order.domain.Order;
import net.will.ebook.product.domain.Product;
import net.will.ebook.trade.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TradeService tradeService;
    
    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public List<Order> createOrder() {
        // 1. login
        Integer userId = this.login();
        
        // 2. check all products
        List<Product> products = this.productService.findAllProducts();
        
        // 3. choose the first product and create order
        Product product = products.get(0);
        Order order = this.order(userId, product);
        
        // 4. pay for the order
        this.pay(userId, order);
        
        // 5. check all the orders
        List<Order> orders = this.orderService.findOrderByUserId(userId);
        return orders;
    }
    
    private Integer login() {
        String username = "admin";
        String password = "admin";
        Integer id = this.userService.login(username, password);
        if (id != null) {
            System.out.println("Login successfully, id=" + id);
        } else {
            System.out.println("Login failed!");
        }
        return id;
    }
    
    private Order order(Integer userId, Product product) {
        Order order  = new Order();
        order.setUserId(userId);
        order.setProductId(product.getId());
        order.setPrice(product.getPrice());
        order.setDeleted((byte) 0);
        Integer id = this.orderService.createOrder(order);
        if (order.getId() == null && id != null) {
            // Setting back the order id manually as it cannot be transferred back from service in this case...
            order.setId(id);
        }
        
        if (id != null) {
            System.out.println("Order created successfully, id=" + id);
        } else {
            System.out.println("Order failed!");
        }
        return order;
    }
    
    private Trade pay(Integer userId, Order order) {
        System.out.println("Order Id: " + order.getId());
        
        Trade trade = new Trade();
        trade.setUserId(userId);
        trade.setOrderId(order.getId());
        trade.setPrice(order.getPrice());
        trade.setPayType((byte) 1);
        trade.setPayStatus((byte) 4);
        trade.setGatewayPayNum( String.valueOf((new Date()).getTime()) );
        trade.setGatewayPayPrice(order.getPrice());
        trade.setGatewayPayTime(new Date());
        System.out.println("orderId property of Trade object: " + trade.getOrderId());
        this.tradeService.createTrade(trade);
        return trade;
    }
}
