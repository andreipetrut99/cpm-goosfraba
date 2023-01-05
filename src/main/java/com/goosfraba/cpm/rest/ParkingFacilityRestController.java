package com.goosfraba.cpm.rest;

import com.goosfraba.cpm.entity.ParkingFacility;
import com.goosfraba.cpm.service.CityFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingFacilityRestController {
    private CityFacilityService cityFacilityService;

    @Autowired
    public ParkingFacilityRestController(CityFacilityService cityFacilityService) {
        this.cityFacilityService = cityFacilityService;
    }

    @PostMapping("/facilities/{cityId}")
    public ParkingFacility saveFacility(@RequestBody ParkingFacility parkingFacility,
                                        @PathVariable String cityId) {
//        parkingFacility.setId();
        cityFacilityService.save(parkingFacility, cityId);

        return parkingFacility;
    }

    @GetMapping("/facilities/{facilityId}")
    public ParkingFacility findFacilityById(@PathVariable String facilityId) {
        ParkingFacility parkingFacility = cityFacilityService.findById(facilityId);

        if (parkingFacility == null) {
            throw new RuntimeException("Facility not found.");
        }

        return parkingFacility;
    }

    @GetMapping("/facilities/city/{cityId}")
    public List<ParkingFacility> getFacilitiesByCity(@PathVariable String cityId) {
        return cityFacilityService.findAll(cityId);
    }
}
