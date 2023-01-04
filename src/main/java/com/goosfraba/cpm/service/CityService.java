package com.goosfraba.cpm.service;

import com.goosfraba.cpm.entity.City;
import java.util.List;

public interface CityService {
    public List<City> findAll();

    public City findById(int id);

    public City findByCode(String code);

    public void save(City city);

    public void deletebyId(int id);
}
