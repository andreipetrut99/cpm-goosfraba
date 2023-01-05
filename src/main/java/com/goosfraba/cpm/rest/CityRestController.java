package com.goosfraba.cpm.rest;

import com.goosfraba.cpm.entity.City;
import com.goosfraba.cpm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRestController {
    private CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/cities/{cityId}")
    public City findById(@PathVariable String cityId) {
        return cityService.findById(cityId);
    }

    @GetMapping("/cities/code/{cityCode}")
    public City findByCode(@PathVariable String cityCode) {
        return cityService.findByCode(cityCode);
    }

    @PostMapping("/cities")
    public City addCity(@RequestBody City city) {
        city.setId(String.valueOf(0));
        cityService.save(city);
        return city;
    }

}
