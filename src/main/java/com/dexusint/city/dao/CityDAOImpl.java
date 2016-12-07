package com.dexusint.city.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexusint.city.model.City;

@Repository("cityDAO")
public class CityDAOImpl implements CityDAO {

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
    public String insertNewCityInfo(City city) {
 
        // inserts into database & return bookId (primary_key)
        int cityId = (Integer) sessionFactory.getCurrentSession().save(city);
        return "City information saved successfully with City_ID " + cityId;
    }
	
    @Override
    @Transactional
    public String updateCityInfo(City updateCity) {
 
        // update database with book information and return success msg
        sessionFactory.getCurrentSession().update(updateCity);
        return "City information updated successfully";
    }
 
    @Override
    @Transactional
    public String removeCityInfo(City removeCity) {
 
        // delete book information and return success msg
        sessionFactory.getCurrentSession().delete(removeCity);
        return "City information with City_ID " + removeCity.getCityId() +  " deleted successfully";
    }
	
    @Override
    @Transactional
    public City getCityInfo(int cityId) {
 
        City city = (City) sessionFactory.getCurrentSession().get(City.class, cityId);
        return city;
    }
 

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<City> getAllCities() {

		// get all books info from database
		List<City> lstBook = sessionFactory.getCurrentSession().createCriteria(City.class).list();
		return lstBook;
	}
}