package com.example.itoolsinterface.repository;


import com.example.itoolsinterface.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Login.LoginResult loginUser(String username, String password) {
        String sql = "SELECT * FROM login_credentials WHERE login_username = ? AND login_password = ?";
        try {
            jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Login.class), username, password);
            return Login.LoginResult.SUCCESS;
        } catch (EmptyResultDataAccessException ex) {
            // Check if username is correct
            String isUsername = getUserByUsername(username);
            return isUsername == null ? Login.LoginResult.INCORRECT_USERNAME : Login.LoginResult.INCORRECT_PASSWORD;
        }
    }


    public Login getLoginSession(String username, String password) {
        String sql = "SELECT * FROM login_credentials " +
                " WHERE login_username = ? AND login_password = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Login.class), username, password);
    }

    public String getUserByUsername(String username) {
        String sql = "SELECT * FROM login_credentials WHERE login_username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Login.class), username).getLoginUsername();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
