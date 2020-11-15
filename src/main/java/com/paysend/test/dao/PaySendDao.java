package com.paysend.test.dao;

import com.paysend.test.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class PaySendDao {

    private SimpleDriverDataSource dataSource;

    public PaySendDao(final SimpleDriverDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveUser(final User user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");

        //jdbcTemplate.execute("drop table users if exists");
        jdbcTemplate.execute("create table users(" +
                "id serial, login varchar(255), password varchar(255))");

        System.out.printf("Inserting user record for %s %s\n", user.getLogin(), user.getPassword());
            jdbcTemplate.update(
                    "INSERT INTO customers(login,password) values(?,?)",
                    user.getLogin(), user.getPassword());
    }

    public User findUser(User user) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("Querying for user records where name = 'Josh':");
        List<User> results = jdbcTemplate.query(
                "select * from users where login = ? and password = ?",
                (RowMapper<User>) (rs, rowNum) ->
                        new User(rs.getLong("id"), rs.getString("login"),
                        rs.getString("password"), null), user.getLogin(), user.getPassword());

        System.out.println(results.get(0));
        return results.get(0);
    }

}

