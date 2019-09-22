package net.will.ebook.product.facade;

import net.will.ebook.product.domain.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductFacadeImpl implements ProductFacade {
    
    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "The first eBook Product"));
        list.add(new Product(2, "The second eBook Product"));
        list.add(new Product(3, "The third eBook Product"));
        return list;
    }
    
}
