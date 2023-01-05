package com.goosfraba.cpm.service;

import com.goosfraba.cpm.dao.CityFacilityDAO;
import com.goosfraba.cpm.entity.ParkingFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityFacilityServiceImpl implements CityFacilityService {
    private CityFacilityDAO cityFacilityDAO;

    @Autowired
    public CityFacilityServiceImpl(CityFacilityDAO cityFacilityDAO) {
        this.cityFacilityDAO = cityFacilityDAO;
    }

    @Override
    @Transactional
    public void save(ParkingFacility parkingFacility, String cityId) {
        cityFacilityDAO.save(parkingFacility, cityId);
    }

    @Override
    @Transactional
    public ParkingFacility findById(String id) {
//        Optional<ParkingFacility> result = cityFacilityDAO.findById(id);
//        return result.orElse(null);
        return cityFacilityDAO.findById(id);
    }

    @Override
    @Transactional
    public List<ParkingFacility> findAll(String cityId) {
        return cityFacilityDAO.findAll(cityId);
    }
}
