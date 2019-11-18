package net.will.ebook.user.facade;

import net.will.ebook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;
    
    @Override
    public Integer login(String username, String password) {
        return this.userService.login(username, password);
    }
    
}
