package com.example.webco2.controllers;

import com.example.webco2.model.CO2Level;
import com.example.webco2.service.CO2LevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class CO2Controller {
    private static final Logger logger = LoggerFactory.getLogger(CO2Controller.class);

    @Autowired
    private CO2LevelService co2LevelService;

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

    @RequestMapping(value = "/record", method = RequestMethod.GET, produces = "application/json")
    public String record(@RequestParam(value="level", required=false, defaultValue="0") Long level, Model model) {
        CO2Level co2Level = new CO2Level(level);
        int result = co2LevelService.save(co2Level);
        logger.info("CO2 level saved, return code "+ result);
        return "chart";
    }
}
