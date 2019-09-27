package net.will.ebook.consumer.controller;

import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/productConsumer")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> list = productService.listProduct();
        return list;
    }
    
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Product getProduct(@RequestParam("id") Integer id) {
        return this.productService.getProduct(id);
    }
    
    @RequestMapping(value = "getComplex", method = RequestMethod.GET)
    public Product getProductComplex(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        return this.productService.getProductComplex(id, name);
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Product addProduct() {
        Product obj = new Product(2, "The second eBook Product");
        return productService.addProduct(obj);
    }
}
