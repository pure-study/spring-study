package net.will.eureka.provider.controller;

import net.will.eureka.provider.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "The first Product"));
        list.add(new Product(2, "The second Product"));
        list.add(new Product(3, "The third Product"));
        return list;
    }
    
}
