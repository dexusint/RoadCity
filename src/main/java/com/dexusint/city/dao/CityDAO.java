package com.dexusint.city.dao;

import java.util.List;

import com.dexusint.city.model.City;

public interface CityDAO {
	public String insertNewCityInfo(City addCity);
	public City getCityInfo(int cityId);
    public String updateCityInfo(City updateCity);
    public String removeCityInfo(City removeCity);
	public List<City> getAllCities();
}