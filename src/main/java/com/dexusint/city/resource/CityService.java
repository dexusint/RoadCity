package com.dexusint.city.resource;

import in.benchresources.cdm.city.CityListType;
import in.benchresources.cdm.city.CityType;

public interface CityService {
    public CityType getCityInfo(int cityId);
    public String updateCityInfo(CityType cityType);
    public String deleteCityInfo(int cityId);
    public String createOrSaveCityInfo(CityType cityType);
	public CityListType getAllCities();
}
