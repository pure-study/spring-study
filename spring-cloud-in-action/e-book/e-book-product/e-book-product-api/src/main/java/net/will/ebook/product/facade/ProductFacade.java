package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/product")
public interface ProductFacade {
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct();
    
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public Product getProduct(@RequestParam("id") Integer id);
    
    @RequestMapping(value = "getProductByObject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductByObject(@RequestBody Product obj);
    
    @RequestMapping(value = "getComplex", method = RequestMethod.GET)
    public Product getProductComplex(@RequestParam("id") Integer id, @RequestParam("name") String name);
    
    @RequestMapping(value = "add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product obj);
}
