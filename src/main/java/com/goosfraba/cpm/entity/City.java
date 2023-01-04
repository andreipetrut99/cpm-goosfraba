package com.goosfraba.cpm.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "code", length = 4)
    private String code;

    @OneToMany(mappedBy = "city",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    private List<ParkingFacility> parkingFacilities;

    public City() {
    }

    public City(String name, String code, List<ParkingFacility> parkingFacilities) {
        this.name = name;
        this.code = code;
        this.parkingFacilities = parkingFacilities;
    }

    // method for bi-directional relationship

    public void add(ParkingFacility parkingFacility) {
        if (parkingFacilities == null) {
            parkingFacilities = new ArrayList<>();
        }

        parkingFacilities.add(parkingFacility);
        parkingFacility.setCity(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ParkingFacility> getParkingFacilities() {
        return parkingFacilities;
    }

    public void setParkingFacilities(List<ParkingFacility> parkingFacilities) {
        this.parkingFacilities = parkingFacilities;
    }
}
