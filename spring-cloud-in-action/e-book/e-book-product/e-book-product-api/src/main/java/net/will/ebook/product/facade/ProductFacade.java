package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
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
    
    @RequestMapping(value = "getComplex", method = RequestMethod.GET)
    public Product getProductComplex(@RequestParam("id") Integer id, @RequestParam("name") String name);
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product obj);
}
