package com.example.webco2.dao;

import com.example.webco2.model.CO2Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CO2LevelDaoImpl implements CO2LevelDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void save(CO2Level level) {

    }

    @Override
    public CO2Level find(long id) {
        String sql = "select level from CO2LOG where id = ?";
        System.out.println(sql);
        Long level = jdbcTemplate.queryForObject(sql,new Object[]{id},Long.class);
        CO2Level co2Level = new CO2Level();
        co2Level.setLevel(level);
        return co2Level;
    }
}
