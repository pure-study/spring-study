package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(value = "/product")
public interface ProductFacade {
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct();
    
}
