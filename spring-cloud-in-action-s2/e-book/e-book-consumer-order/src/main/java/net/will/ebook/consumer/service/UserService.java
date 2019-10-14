package net.will.ebook.consumer.service;

import net.will.ebook.user.facade.UserFacade;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "e-book-user")
public interface UserService extends UserFacade {
}
