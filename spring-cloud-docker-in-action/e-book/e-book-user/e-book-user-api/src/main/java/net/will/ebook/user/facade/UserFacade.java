package net.will.ebook.user.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "/user")
public interface UserFacade {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Integer login(@RequestParam("username") String username, @RequestParam("password") String password);
}
