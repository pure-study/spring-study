package net.will.ebook.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import net.will.ebook.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    
    @HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {@HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
                    @HystrixProperty(name = "maxRequestsInBatch", value = "200")}
    )
    public Future<Product> getProduct(Integer id) {
        LOGGER.info("------------- getProduct {} -------------", id); // expect no output of this line
        return null;
    }
    
    @HystrixCommand
    public List<Product> batchProduct(List<Integer> ids) {
        ids.forEach(id -> LOGGER.info("---------in batchProduct: {}", id));
        
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "The first eBook Product"));
        list.add(new Product(2, "The second eBook Product"));
        list.add(new Product(3, "The third eBook Product"));
        list.add(new Product(4, "The fourth eBook Product"));
        return list;
    }
}
