package net.will.ebook.consumer.hystrix;

import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceFallback implements ProductService {
    @Override
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(-1, "fallback"));
        return list;
    }
}
