package com.example.webco2.dao;


import com.example.webco2.model.CO2Level;

public interface CO2LevelDao {

    int save(CO2Level level);

    long remove(long id);

    CO2Level find(long id);
}
