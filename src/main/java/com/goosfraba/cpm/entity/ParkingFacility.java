package com.goosfraba.cpm.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ParkingFacility {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;


    @Column(name = "capacity")
    private int capacity;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "available_capacity")
    private int availableCapacity;

    public ParkingFacility() {
    }

    public ParkingFacility(String name, int capacity, City city, int availableCapacity) {
        this.name = name;
        this.capacity = capacity;
        this.city = city;
        this.availableCapacity = availableCapacity;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    @Override
    public String toString() {
        return "ParkingFacility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", city=" + city +
                ", availableCapacity=" + availableCapacity +
                '}';
    }
}
