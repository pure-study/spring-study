package net.will.ebook.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.product.domain.Product;

@RestController
public class SleuthProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "/listProduct", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> products = this.productService.findAllProducts();
        return products;
    }
}
