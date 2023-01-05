package com.goosfraba.cpm.service;

import com.goosfraba.cpm.entity.City;
import com.goosfraba.cpm.entity.ParkingFacility;

import java.util.List;

public interface CityFacilityService {
    public void save(ParkingFacility parkingFacility, String cityId);
    public ParkingFacility findById(String id);
    public List<ParkingFacility> findAll(String cityId);
}
