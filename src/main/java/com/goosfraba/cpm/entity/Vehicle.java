package com.goosfraba.cpm.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "is_parked")
    private boolean isParked;

    @Column(name = "parking_facility_id")
    private String parkingFacilityId;

    public Vehicle() {
    }

    public Vehicle(City city, boolean isParked, String parkingFacilityId) {
        this.city = city;
        this.isParked = isParked;
        this.parkingFacilityId = parkingFacilityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }

    public String getParkingFacilityId() {
        return parkingFacilityId;
    }

    public void setParkingFacilityId(String parkingFacilityId) {
        this.parkingFacilityId = parkingFacilityId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", city=" + city +
                ", isParked=" + isParked +
                ", parkingFacilityId='" + parkingFacilityId + '\'' +
                '}';
    }
}
