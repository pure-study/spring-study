package net.will.springboottest.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("net.will.springboottest.dao")
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@EnableAutoConfiguration
public class TestConfiguration {}
