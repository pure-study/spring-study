package net.will.ebook.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import net.will.ebook.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CacheConfig(cacheNames = {"net.will.ebook"})
@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;  // Ribbon load balance client
    
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS,
                    value = "15")
    })
    public List<Product> listProduct() {
        ServiceInstance si = loadBalancerClient.choose("e-book-provider");
        StringBuilder reqUrl = new StringBuilder()
                .append("http://").append(si.getHost()).append(":").append(si.getPort())
                .append("/product/list");
        LOGGER.info("Requesting URL: {}", reqUrl.toString());
        
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> typeReference = new ParameterizedTypeReference<List<Product>>() {
        };
        ResponseEntity<List<Product>> responseEntity =
                restTemplate.exchange(reqUrl.toString(), HttpMethod.GET, null, typeReference);
        return responseEntity.getBody();
    }
    
    public List<Product> fallback() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(-1, "fallback"));
        return list;
    }
    
    @Cacheable(key = "'product' + #id")
    public Product get(Integer id) {
        LOGGER.info("=========get======== {}", id);
        return new Product(id, "A product from get(Integer)");
    }
    
    @CacheEvict(key = "'product' + #id")
    public void delete(Integer id) {
        LOGGER.info("=========delete======== {}", id);
    }
}
