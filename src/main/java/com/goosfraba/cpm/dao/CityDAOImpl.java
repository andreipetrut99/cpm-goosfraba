package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.City;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CityDAOImpl implements CityDAO {
    private EntityManager entityManager;

    @Autowired
    public CityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(City city) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(city);
    }
}
