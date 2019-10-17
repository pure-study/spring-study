package net.will.ebook.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ErrorFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
    
    @Override
    public String filterType() {
        return "error";
    }
    
    @Override
    public int filterOrder() {
        return 0;
    }
    
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    @Override
    public Object run() throws ZuulException {
        logger.info("----------error---------");
        return null;
    }
}
