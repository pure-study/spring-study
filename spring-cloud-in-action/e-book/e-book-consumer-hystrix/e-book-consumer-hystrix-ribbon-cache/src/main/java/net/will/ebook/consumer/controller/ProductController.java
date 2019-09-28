package net.will.ebook.consumer.controller;

import net.will.ebook.consumer.domain.Product;
import net.will.ebook.consumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/productHystrix")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> list = productService.listProduct();
        return list;
    }
    
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Product get(Integer id) {
        return this.productService.get(id);
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void delete(Integer id) {
        this.productService.delete(id);
    }
    
}
