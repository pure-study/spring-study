package net.will.ebook.consumer.hystrix;

import feign.hystrix.FallbackFactory;
import net.will.ebook.consumer.service.ProductService;
import net.will.ebook.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Override
    public ProductService create(Throwable cause) {
        return () -> {
            logger.warn("fallback exception.", cause);
            List<Product> list = new ArrayList<>();
            list.add(new Product(-1, "fallback"));
            return list;
        };
    }
}
