package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.City;
import com.goosfraba.cpm.entity.Vehicle;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {
    EntityManager entityManager;

    @Autowired
    public VehicleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Vehicle save(String cityId, Vehicle vehicle) {
        Session currentSession = entityManager.unwrap(Session.class);
        vehicle.setId(null);

        City city = currentSession.get(City.class, cityId);
        vehicle.setCity(city);
        currentSession.saveOrUpdate(vehicle);

        return vehicle;
    }

    @Override
    public List<Vehicle> findAllByCode(String cityCode) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from Vehicle where city.code=:cityCode");
        query.setParameter("cityCode", cityCode);
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(vehicle);
    }
}
