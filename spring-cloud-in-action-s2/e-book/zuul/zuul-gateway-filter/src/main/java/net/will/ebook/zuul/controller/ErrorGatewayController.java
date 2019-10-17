package net.will.ebook.zuul.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorGatewayController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    
    @RequestMapping(value = "/error")
    public String error() {
        return "{\"result\": \"Got an error!\"}";
    }
}
