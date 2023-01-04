package com.goosfraba.cpm.rest;

import com.goosfraba.cpm.dao.CityDAO;
import com.goosfraba.cpm.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CityRestController {
    @Autowired
    private CityDAO cityDAO;

    @PostMapping("/cities")
    public City addCity(@RequestBody City city) {
        city.setId(String.valueOf(0));
        cityDAO.save(city);
        return city;
    }
}
