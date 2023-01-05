package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.City;
import com.goosfraba.cpm.entity.ParkingFacility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityFacilityDAOImpl implements CityFacilityDAO {
    private EntityManager entityManager;

    @Autowired
    public CityFacilityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(ParkingFacility parkingFacility, String cityId) {
        Session currentSession = entityManager.unwrap(Session.class);
        City city = currentSession.get(City.class, cityId);

        city.add(parkingFacility);
        parkingFacility.setCity(city);
        currentSession.saveOrUpdate(parkingFacility);
    }

    @Override
    public ParkingFacility findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(ParkingFacility.class, id);
    }

    @Override
    public List<ParkingFacility> findAll(String cityId) {
        Session currentSession = entityManager.unwrap(Session.class);
        City city = currentSession.get(City.class, cityId);

        if (city == null) {
            throw new RuntimeException("City not found.");
        }

        Query query = currentSession.createQuery("from ParkingFacility where " +
                "city=:facilityCity");
        query.setParameter("facilityCity", city);
        List<ParkingFacility> facilities = query.getResultList();
        return facilities;
    }
}
