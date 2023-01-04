package com.goosfraba.cpm.service;

import com.goosfraba.cpm.dao.CityDAO;
import com.goosfraba.cpm.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private CityDAO cityDAO;

    @Autowired
    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    @Transactional
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    @Transactional
    public City findById(int id) {
        return cityDAO.findById(id);
    }

    @Override
    @Transactional
    public City findByCode(String code) {
        return cityDAO.findByCode(code);
    }

    @Override
    @Transactional
    public void save(City city) {
        cityDAO.save(city);
    }

    @Override
    @Transactional
    public void deletebyId(int id) {

    }
}
