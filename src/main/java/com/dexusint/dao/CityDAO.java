package com.dexusint.dao;

import java.util.List;

import com.dexusint.model.City;

public interface CityDAO {
	public String insertNewCityInfo(City addCity);
	public City getCityInfo(int cityId);
    public String updateCityInfo(City updateCity);
    public String removeCityInfo(City removeCity);
	public List<City> getAllCities();
}