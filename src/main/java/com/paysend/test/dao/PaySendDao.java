package com.paysend.test.dao;

import com.paysend.test.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class PaySendDao extends JdbcDaoSupport {

    @Autowired
    private SimpleDriverDataSource dataSource;

    public PaySendDao(final SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void saveUser(final User user) {

        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        log.debug("Creating tables");

        //jdbcTemplate.execute("drop table users if exists");
        jdbcTemplate.execute("create table users(" +
                "id serial, login varchar(255), password varchar(255))");

        log.debug("Inserting user record for %s %s\n", user.getLogin(), user.getPassword());

        jdbcTemplate.update(
                "INSERT INTO customers(login,password) values(?,?)",
                user.getLogin(), user.getPassword());
    }

    public User findUser(User user) {

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        log.debug("Querying for user records where name = 'Josh':");
        List<User> results = jdbcTemplate.query(
                "select * from users where login = ? and password = ?",
                (RowMapper<User>) (rs, rowNum) ->
                        new User(rs.getLong("id"), rs.getString("login"),
                        rs.getString("password"), null), user.getLogin(), user.getPassword());

        log.debug("Resuls size ", results.size());
        return results.get(0);
    }

}

