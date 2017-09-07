package com.example.webco2.dao;


import com.example.webco2.model.CO2Level;

public interface CO2LevelDao {

    void save(CO2Level level);

    CO2Level find(long id);
}
