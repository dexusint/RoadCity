package com.dexusint.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dexusint.model.City;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<City> getAllCities() {

		// get all books info from database
		List<City> lstBook = sessionFactory.getCurrentSession().createCriteria(City.class).list();
		return lstBook;
	}
}