package com.example.webco2.service;


import com.example.webco2.model.CO2Level;

public interface CO2LevelService {
    void save(CO2Level level);

    CO2Level find(long id);
}
