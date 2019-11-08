package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import net.will.ebook.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductService productService;
    
    public List<Product> findAllProducts() {
        return this.productService.findAllProducts();
    }
    
    @Override
    public List<Product> listProduct() {
        System.out.println("Coming into ProductFacadeImpl.listProduct()...");
        /*try { // test this for Zuul gateway timeout
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return this.productService.findAllProducts();
    }
    
    @Override
    public Product getProduct(Integer id) {
        return this.productService.getProduct(id);
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
