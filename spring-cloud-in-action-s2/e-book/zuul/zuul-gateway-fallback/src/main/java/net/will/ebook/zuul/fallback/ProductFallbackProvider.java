package net.will.ebook.zuul.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ProductFallbackProvider implements FallbackProvider {
    private static final Logger logger = LoggerFactory.getLogger(ProductFallbackProvider.class);
    
    @Override
    public String getRoute() {
        return "e-book-product";
    }
    
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause != null) {
            logger.error(cause.getMessage(), cause);
        }
        
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
    
            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }
    
            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }
    
            @Override
            public void close() {}
    
            @Override
            public InputStream getBody() throws IOException {
                String input = "Product service is not available, please contact the administrator.";
                return new ByteArrayInputStream(input.getBytes());
            }
    
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.TEXT_PLAIN);
                return httpHeaders;
            }
        };
    }
}
