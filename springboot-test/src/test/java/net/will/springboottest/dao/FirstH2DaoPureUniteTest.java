package net.will.springboottest.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class FirstH2DaoPureUniteTest {
    private IFirstH2Dao firstH2Dao;
    
    private EmbeddedDatabase db;
    
    @Before
    public void setUp() {
        db = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        firstH2Dao = new FirstH2Dao(new JdbcTemplate(db));
    }

    @Test
    public void testCreateTableAndInsert() {
        firstH2Dao.createTable();

        firstH2Dao.insert();
        
        assertNotNull("No exceptions here.");
    }

}
