package com.example.webco2.model;


import java.util.Date;

public class CO2Level {
    private Long level;
    private Date datetime;

    public CO2Level(){
    }

    public CO2Level(Long level){
      this.setLevel(level);
    }

    public CO2Level(Long level, Date datetime){
        this.setLevel(level);
        this.setDatetime(datetime);
    }
    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
