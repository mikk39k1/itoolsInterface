package com.example.itoolsinterface.repository;

import com.example.itoolsinterface.model.Card;
import com.example.itoolsinterface.model.CardWithImage;
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

    public List<CardWithImage> getAllCardsVisibleToAll() {
        String sql = "SELECT * FROM card JOIN images USING (card_id) WHERE card_loginIsRequired = 0";
        RowMapper<CardWithImage> rowMapper = new BeanPropertyRowMapper<>(CardWithImage.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public void createNewCard(String cardTitle, String cardLink, boolean cardIsLoginRequired) {
        String sql = "INSERT INTO card (card_title, card_link, card_loginIsRequired) VALUES (?,?,?)";
        jdbcTemplate.update(sql, cardTitle, cardLink, cardIsLoginRequired);
    }

    public Integer getCardIdFromTitle(String cardTitle) {
        String sql = "SELECT card_id FROM card WHERE card_title = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, cardTitle);
    }

    public void saveImage(int cardId, String imagePath) {
        String sql = "INSERT INTO images (image_path, card_id) VALUES (?,?)";
        jdbcTemplate.update(sql, imagePath, cardId);
    }

    public List<CardWithImage> getAllCardsVisibleToLoggedIn() {
        String sql = "SELECT * FROM card JOIN images USING (card_id) WHERE card_loginIsRequired = 1";
        RowMapper<CardWithImage> rowMapper = new BeanPropertyRowMapper<>(CardWithImage.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}

