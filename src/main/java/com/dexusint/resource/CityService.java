package com.dexusint.resource;

import javax.ws.rs.PathParam;

import in.benchresources.cdm.city.CityListType;
import in.benchresources.cdm.city.CityType;

public interface CityService {
    public CityType getCityInfo(int cityId);
    public String createOrSaveCityInfo(CityType cityType);
	public CityListType getAllCities();
}
