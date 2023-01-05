package com.goosfraba.cpm.service;

import com.goosfraba.cpm.dao.VehicleDAO;
import com.goosfraba.cpm.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleDAO vehicleDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    @Transactional
    public Vehicle save(String cityId, Vehicle vehicle) {
        return vehicleDAO.save(cityId, vehicle);
    }

    @Override
    @Transactional
    public List<Vehicle> findAllByCode(String cityCode) {
        return vehicleDAO.findAllByCode(cityCode);
    }

    @Override
    @Transactional
    public void updateVehicle(Vehicle vehicle) {
        vehicleDAO.updateVehicle(vehicle);
    }
}
