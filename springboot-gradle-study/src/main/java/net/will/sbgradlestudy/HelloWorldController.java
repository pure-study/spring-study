package net.will.sbgradlestudy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${hello.msg}")
    private String msg;
    
    @RequestMapping("/hello")
    public String hello() {
        return this.msg;
    }
}
