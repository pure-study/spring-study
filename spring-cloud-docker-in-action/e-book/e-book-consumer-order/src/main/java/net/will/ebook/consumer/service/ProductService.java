package net.will.ebook.consumer.service;

import net.will.ebook.product.facade.ProductFacade;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "e-book-product")
public interface ProductService extends ProductFacade {
}
