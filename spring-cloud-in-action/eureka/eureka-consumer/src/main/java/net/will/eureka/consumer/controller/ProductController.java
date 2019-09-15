package net.will.eureka.consumer.controller;

import net.will.eureka.consumer.domain.Product;
import net.will.eureka.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> list = productService.listProduct();
        return list;
    }
    
}
