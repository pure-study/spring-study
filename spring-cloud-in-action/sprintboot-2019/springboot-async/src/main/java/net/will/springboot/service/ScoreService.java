package net.will.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ScoreService {
    private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);
    
    @Async
    public void addScore() {
        try {
            TimeUnit.SECONDS.sleep(5);
            logger.info("-----------------Handling scores-----------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Async("scorePoolTaskExecutor")
    public void addScoreInCustomThreadPool() {
        try {
            TimeUnit.SECONDS.sleep(5);
            logger.info("-----------------Handling scores2-----------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
