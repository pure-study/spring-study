package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;

@RestController
public class ProductFacadeImpl implements ProductFacade {
    
    @Override
    public List<Product> listProduct() {
        System.out.println("Coming into ProductFacadeImpl.listProduct()...");
//        try {
//            // for timeout tests
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "The first eBook Product"));
        list.add(new Product(2, "The second eBook Product"));
        list.add(new Product(3, "The third eBook Product"));
        return list;
    }
    
    @Override
    public Product getProduct(Integer id) {
        return new Product(id, "The second eBook Product");
    }
    
    @Override
    public Product getProductByObject(Product obj) {
        return obj;
    }
    
    @Override
    public Product getProductComplex(Integer id, String name) {
        return new Product(id, name);
    }
    
    @Override
    public Product addProduct(@RequestBody Product obj) {
        return obj;
    }
    
}
