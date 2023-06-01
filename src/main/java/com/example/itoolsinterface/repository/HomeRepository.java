package com.example.itoolsinterface.repository;

import com.example.itoolsinterface.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HomeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public Map<User, Boolean> getUser(String username, String password){
        String sql = "SELECT * FROM login_credentials WHERE BINARY username = ? AND BINARY password = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        Map<User,Boolean> loginResult = new HashMap<>();
        User user = null;
        boolean succes = false;
        try {
            user = jdbcTemplate.queryForObject(sql, rowMapper, username, password);
            succes = true;
        } catch (EmptyResultDataAccessException ex){
            System.out.println("Exeption: " + ex);
        }
         loginResult.put(user, succes);
        return loginResult;
    }
}
