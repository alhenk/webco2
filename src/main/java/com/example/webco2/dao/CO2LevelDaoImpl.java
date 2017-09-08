package com.example.webco2.dao;

import com.example.webco2.model.CO2Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

@Repository
public class CO2LevelDaoImpl implements CO2LevelDao {

    @Value("${co2level.db.table}")
    private String so2Table;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    @Transactional
    public int save(CO2Level co2Level) {
        String sql = "insert into "+ so2Table + "(level, datetime) values(?,?)";
        Date date =new Date();
        Long level = co2Level.getLevel();
        return jdbcTemplate.update(sql, level, date);
    }

    @Override
    @Transactional
    public long remove(long id) {
        String sql = "delete from "+ so2Table + " where id = ?";
        return jdbcTemplate.update(sql,new Object[]{id},Long.class);
    }

    @Override
    @Transactional
    public CO2Level find(long id) {
        String sql = "select level from "+ so2Table + " where id = ?";
        System.out.println(sql);
        Long level = jdbcTemplate.queryForObject(sql,new Object[]{id},Long.class);
        CO2Level co2Level = new CO2Level(level);
        co2Level.setLevel(level);
        return co2Level;
    }

    @Override
    public Collection<CO2Level> getAll() {
        String sql = "select * from "+ so2Table;
        return null;
    }
}
