package net.will.ebook.user.service;

import net.will.ebook.user.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public Integer login(String username, String password) {
        return this.userMapper.login(username, password);
    }
}
