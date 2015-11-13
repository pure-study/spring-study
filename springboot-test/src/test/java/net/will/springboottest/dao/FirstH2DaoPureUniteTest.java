package net.will.springboottest.dao;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

@Ignore("Manually run this test to avoid multiple times execution on initial SQL script.")
public class FirstH2DaoPureUniteTest {
    private static IFirstH2Dao firstH2Dao;
    
    private static DataSource ds;
    
    @BeforeClass
    public static void runBeforeClass() {
        ds = new EmbeddedDatabaseConfiguration().dataSource();
        firstH2Dao = new FirstH2Dao(new JdbcTemplate(ds));
    }

    @Test
    public void testInsert() {
        firstH2Dao.insert();
        
        assertNotNull("No exceptions here.");
    }

    @Test
    public void testMinorOperationOnDb() {
        firstH2Dao.minorOperationOnDb();
        
        assertNotNull("No exceptions here.");
    }

}
