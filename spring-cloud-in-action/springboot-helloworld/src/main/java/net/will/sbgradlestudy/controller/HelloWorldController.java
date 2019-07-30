package net.will.sbgradlestudy.controller;

import net.will.sbgradlestudy.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${hello.msg}")
    private String msg;

    @RequestMapping("/hello")
    public String hello() {
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
