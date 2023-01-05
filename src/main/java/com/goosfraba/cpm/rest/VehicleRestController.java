package com.goosfraba.cpm.rest;

import com.goosfraba.cpm.entity.Vehicle;
import com.goosfraba.cpm.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleRestController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles/{cityId}")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle, @PathVariable String cityId) {
        vehicleService.save(cityId, vehicle);

        return vehicle;
    }

    @GetMapping("/vehicles/{cityCode}")
    public List<Vehicle> getVehiclesByCode(@PathVariable String cityCode) {
        return vehicleService.findAllByCode(cityCode);
    }

    @PutMapping("/vehicles/{facilityId}")
    public String parkVehicle(@PathVariable String facilityId, @RequestBody Vehicle vehicle) {
        vehicle.setParked(true);
        vehicle.setParkingFacilityId(facilityId);

        vehicleService.updateVehicle(vehicle);

        return "Vehicled parked in facility " + facilityId;
    }

    @PutMapping("/vehicles")
    public String unParkVehicle(@RequestBody Vehicle vehicle) {
        vehicle.setParked(false);
        vehicle.setParkingFacilityId(null);

        vehicleService.updateVehicle(vehicle);

        return "Vehicle un-parked.";
    }
}
