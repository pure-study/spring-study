package net.will.springstudy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {
    private static SpringContextUtil singleton = new SpringContextUtil();
    
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    public Object getBean(String id) {
        return applicationContext.getBean(id);
    }
    
    private SpringContextUtil() {}
    
    public static SpringContextUtil getInstance() {
        return singleton;
    }

}
