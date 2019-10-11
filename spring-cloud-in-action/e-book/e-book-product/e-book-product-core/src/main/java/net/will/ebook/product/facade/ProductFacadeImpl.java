package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import net.will.ebook.product.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.TimeUnit;

@RestController
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductMapper productMapper;
    
    public List<Product> findAllProducts() {
        return this.productMapper.findAllProducts();
    }
    
    @Override
    public List<Product> listProduct() {
        System.out.println("Coming into ProductFacadeImpl.listProduct()...");
        return this.productMapper.findAllProducts();
    }
    
    @Override
    public Product getProduct(Integer id) {
        return this.productMapper.selectByPrimaryKey(id);
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
