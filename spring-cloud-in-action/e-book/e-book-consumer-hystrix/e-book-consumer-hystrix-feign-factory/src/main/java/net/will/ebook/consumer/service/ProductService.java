package net.will.ebook.consumer.service;

import net.will.ebook.consumer.hystrix.ProductServiceFallbackFactory;
import net.will.ebook.product.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "e-book-provider", fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {
    @RequestMapping(value = "product/list", method = RequestMethod.GET)
    public List<Product> listProduct();
}
