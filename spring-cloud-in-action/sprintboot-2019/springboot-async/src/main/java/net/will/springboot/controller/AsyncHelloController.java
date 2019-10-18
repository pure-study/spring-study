package net.will.springboot.controller;

import net.will.springboot.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncHelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncHelloController.class);
    
    @Autowired
    private ScoreService scoreService;

    @RequestMapping("/async")
    public String createUser() {
        LOGGER.info("-------------Registering a user----------------");
        this.scoreService.addScore();
        return "OK";
    }
    
    @RequestMapping("/async2")
    public String createUser2() {
        LOGGER.info("-------------Registering a user2----------------");
        this.scoreService.addScoreInCustomThreadPool();
        return "OK";
    }
    
}
