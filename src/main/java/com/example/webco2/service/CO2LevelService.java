package com.example.webco2.service;


import com.example.webco2.model.CO2Level;

import java.util.Collection;

public interface CO2LevelService {
    int save(CO2Level level);

    Collection<CO2Level> findCurrent();

    CO2Level find(long id);
}
