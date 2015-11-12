package net.will.springboottest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FirstH2Dao {
    private final JdbcTemplate jdbcTemplate;
    
    private String tableName = "first_h2_dao";
    
    @Autowired
    public FirstH2Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void createTable() {
        jdbcTemplate.execute(String.format("create table %s(id int primary key, name varchar(255))", tableName));
    }
    
    public void insert() {
        jdbcTemplate.update(String.format("insert into %s(id, name) values(1, 'name001')", tableName));
    }
}
