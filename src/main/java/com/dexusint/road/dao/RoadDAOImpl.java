package com.dexusint.road.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexusint.road.model.Road;

@Repository("roadDAO")
public class RoadDAOImpl implements RoadDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
    @Transactional
    public String insertNewRoadInfo(Road city) {
 
        // inserts into database & return bookId (primary_key)
        int cityId = (Integer) sessionFactory.getCurrentSession().save(city);
        return "Road information saved successfully with Road_ID " + cityId;
    }
	
    @Override
    @Transactional
    public String updateRoadInfo(Road updateRoad) {
 
        // update database with book information and return success msg
        sessionFactory.getCurrentSession().update(updateRoad);
        return "Road information updated successfully";
    }
 
    @Override
    @Transactional
    public String removeRoadInfo(Road removeRoad) {
 
        // delete book information and return success msg
        sessionFactory.getCurrentSession().delete(removeRoad);
        return "Road information with Road_ID " + removeRoad.getRoadId() +  " deleted successfully";
    }
	
    @Override
    @Transactional
    public Road getRoadInfo(int cityId) {
 
        Road city = (Road) sessionFactory.getCurrentSession().get(Road.class, cityId);
        return city;
    }
 

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Road> getAllCities() {

		// get all books info from database
		List<Road> lstBook = sessionFactory.getCurrentSession().createCriteria(Road.class).list();
		return lstBook;
	}
}