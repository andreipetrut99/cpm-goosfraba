package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.City;

import java.util.List;

public interface CityDAO {
    public List<City> findAll();

    public City findById(String id);

    public City findByCode(String code);

    public void save(City city);

    public void deletebyId(String id);
}
