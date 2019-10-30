package net.will.ebook.product.service;

import net.will.ebook.product.domain.Product;
import net.will.ebook.product.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    
    public List<Product> findAllProducts() {
        return this.productMapper.findAllProducts();
    }
    
    public List<Product> listProduct() {
        return this.productMapper.findAllProducts();
    }
    
    public Product getProduct(Integer id) {
        return this.productMapper.selectByPrimaryKey(id);
    }
}
