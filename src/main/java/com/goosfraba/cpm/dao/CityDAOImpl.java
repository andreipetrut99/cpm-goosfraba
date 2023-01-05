package com.goosfraba.cpm.dao;

import com.goosfraba.cpm.entity.City;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {
    private EntityManager entityManager;

    @Autowired
    public CityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<City> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from City", City.class);

        List<City> cities = query.getResultList();

        return cities;
    }

    @Override
    public City findById(String id) {
        Session currentSession = entityManager.unwrap(Session.class);
        City city = currentSession.get(City.class, id);

        return city;
    }

    @Override
    public City findByCode(String code) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from City where code=:cityCode");
        query.setParameter("cityCode", code);

        return (City) query.getResultList().get(0);
    }

    @Override
    public void save(City city) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(city);
    }

    @Override
    public void deletebyId(String id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from City where id=:cityId");
        query.setParameter("cityId", id);
        query.executeUpdate();
    }
}
