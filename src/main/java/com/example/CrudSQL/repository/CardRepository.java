package com.example.CrudSQL.repository;

import com.example.CrudSQL.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository implements ICardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Card> findAll() {

        String SQL = "SELECT * FROM Cards WHERE status = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Card.class));
    }

    @Override
    public int save(Card card) {
        String SQL = "INSERT INTO cards VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{card.getName(), card.getNumber(), card.getType(),card.getCcv(),card.getStatus()});
    }

    @Override
    public int update(Card card) {
        String SQL = "UPDATE cards SET Name = ?,Number = ?, Type = ?, Ccv = ? WHERE Id = ?";
        return jdbcTemplate.update(SQL, new Object[]{card.getName(), card.getNumber(), card.getType(),card.getCcv(),card.getId()});
    }

    @Override
    public int deleteById(int Id) {
        String SQL = "UPDATE cards SET Status = 0 WHERE Id = ?";
        return jdbcTemplate.update(SQL, new Object[]{Id});
    }
}
