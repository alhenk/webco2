package com.example.webco2.service;


import com.example.webco2.dao.CO2LevelDao;
import com.example.webco2.model.CO2Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CO2LevelServiceImpl implements CO2LevelService {

    @Autowired
    private CO2LevelDao co2LevelDao;

    public void setCO2LevelDao(CO2LevelDao co2LevelDao){
        this.co2LevelDao = co2LevelDao;
    }

    @Override
    public void save(CO2Level level) {
        co2LevelDao.save(level);
    }

    @Override
    public CO2Level find(long id) {
        return co2LevelDao.find(id);
    }
}