package com.example.itoolsinterface.repository;

import com.example.itoolsinterface.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class CardRepo {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Card> getAllCards() {
        String sql = "SELECT * FROM cards;";
        RowMapper<Card> rowMapper = new BeanPropertyRowMapper<>(Card.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void createNewCard(String cardHeader, String cardLink, File cardImage) {
        String sql = "INSERT INTO cards (card_header, card_link, card_img) VALUES (?,?,?)";
        jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Card.class) ,cardHeader, cardLink, cardImage);
    }
}

