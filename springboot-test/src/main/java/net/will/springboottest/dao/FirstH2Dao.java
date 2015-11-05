package net.will.springboottest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FirstH2Dao {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public FirstH2Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void insert() {
        jdbcTemplate.execute("create table first_h2_dao(id int primary key, name varchar(255))");
    }
}
