package net.will.springboottest.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmbeddedDatabaseConfiguration.class)
@Transactional
public class FirstH2DaoIT {
    @Autowired
    private IFirstH2Dao firstH2Dao;

    @Ignore("Not ready")
    @Test
    public void testInsert() {
        firstH2Dao.insert();
        
        assertNotNull("No exceptions here.");
    }

}
