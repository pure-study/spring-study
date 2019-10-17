package net.will.ebook.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);
    
    @Override
    public String filterType() {
        return "pre";
    }
    
    @Override
    public int filterOrder() {
        return 1;
    }
    
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("--------pre order 1-------");
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("token is null............");
            requestContext.setSendZuulResponse(false);  // ends response
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody("{\"result\": \"token is null\"}");
            requestContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        } else {
            logger.info("token is valid");
        }
        return null;
    }
}
