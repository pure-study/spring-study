package net.will.ebook.consumer.controller;

import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping(value = "/productHystrix")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "testList", method = RequestMethod.GET)
    public void testList() throws ExecutionException, InterruptedException {
        Future<Product> p1 = productService.getProduct(1);
        Future<Product> p2 = productService.getProduct(2);
        Future<Product> p3 = productService.getProduct(3);
        
        LOGGER.info(p1.get().toString());
        LOGGER.info(p2.get().toString());
        LOGGER.info(p3.get().toString());
    }
    
}
