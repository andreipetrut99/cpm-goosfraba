package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.Vehicle;
import java.util.List;

public interface VehicleDAO {
    public Vehicle save(String cityId, Vehicle vehicle);
    public List<Vehicle> findAllByCode(String cityCode);
    public void updateVehicle(Vehicle vehicle);
}
