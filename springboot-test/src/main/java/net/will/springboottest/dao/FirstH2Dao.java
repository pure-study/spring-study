package net.will.springboottest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FirstH2Dao implements IFirstH2Dao {
    private final JdbcTemplate jdbcTemplate;
    
    private String tableName = "first_h2_dao";
    
    @Autowired
    public FirstH2Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void insert() {
        jdbcTemplate.update(String.format("insert into %s(id, name) values(1, 'name001')", tableName));
    }
    
    @Override
    public void minorOperationOnDb() {
        jdbcTemplate.execute(String.format("select * from %s", tableName));
    }
}
