package net.will.sbgradlestudy.controller;

import net.will.sbgradlestudy.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
    
    @Value("${hello.msg}")
    private String msg;

    @RequestMapping("/hello")
    public String hello() {
        LOGGER.trace("Comming into hello()");
        
        if (msg != null) {
            throw new BusinessException("1", "This is a business Exception.");
        }
        return this.msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
