package com.example.webco2.model;


import java.util.Date;

public class CO2Level {
    private Long level;
    private Date date;

    public CO2Level(){
    }

    public CO2Level(Long level){
      this.setLevel(level);
    }

    public CO2Level(Long level, Date date){
        this.setLevel(level);
        this.setDate(date);
    }
    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
