package com.example.webco2.service;


import com.example.webco2.dao.CO2LevelDao;
import com.example.webco2.model.CO2Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CO2LevelServiceImpl implements CO2LevelService {

    @Autowired
    private CO2LevelDao co2LevelDao;

    public void setCO2LevelDao(CO2LevelDao co2LevelDao){
        this.co2LevelDao = co2LevelDao;
    }

    @Override
    public int save(CO2Level level) {
        co2LevelDao.save(level);
        return 0;
    }

    @Override
    public Collection<CO2Level> findCurrent() {
        Collection<CO2Level> allCurrent = co2LevelDao.getAllCurrent();
        return allCurrent;
    }

    @Override
    public CO2Level find(long id) {
        return co2LevelDao.find(id);
    }
}
