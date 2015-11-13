package hello;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import net.will.springboottest.dao.IFirstH2Dao;

@SpringBootApplication
@ComponentScan({ "net.will.springboottest.dao", "hello" })
public class Application implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);
    
    private IFirstH2Dao firstH2Dao;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Coming into run()...");
        firstH2Dao.minorOperationOnDb();
        LOG.info("Exiting run()...");
    }

    public IFirstH2Dao getFirstH2Dao() {
        return firstH2Dao;
    }

    @Autowired
    public void setFirstH2Dao(IFirstH2Dao firstH2Dao) {
        this.firstH2Dao = firstH2Dao;
    }

}
