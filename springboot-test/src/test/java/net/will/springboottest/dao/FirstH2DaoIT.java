package net.will.springboottest.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class FirstH2DaoIT {
    private FirstH2Dao firstH2Dao;

    @Ignore("Not ready")
    @Test
    public void testCreateTableAndInsert() {
        firstH2Dao.createTable();

        firstH2Dao.insert();
        
        assertNotNull("No exceptions here.");
    }

}
