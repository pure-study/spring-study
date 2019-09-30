package net.will.ebook.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import net.will.ebook.product.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;  // Ribbon load balance client
    
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000")
    })
    public List<Product> listProduct(Integer n) {
        LOGGER.info(n.toString());
        if (new Integer(1).equals(n)) {
            throw new RuntimeException("Faked error");
        }
        
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
    
    public List<Product> fallback(Integer n) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(-1, "fallback"));
        return list;
    }
}
