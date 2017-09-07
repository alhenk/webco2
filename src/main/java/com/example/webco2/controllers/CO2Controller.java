package com.example.webco2.controllers;

import com.example.webco2.service.CO2LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CO2Controller {

    @Autowired
    public CO2LevelService co2LevelService;

    public void setCO2LevelService(CO2LevelService levelService){
        this.co2LevelService = levelService;
    }

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        Long level = co2LevelService.find(1L).getLevel();
        System.out.println(level);
        model.put("message", this.message);
        model.put("co2level", level.toString());
        return "welcome";
    }

    @RequestMapping("/chart")
    public String welcome() {
        return "chart";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
