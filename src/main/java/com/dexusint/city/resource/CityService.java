package com.dexusint.city.resource;

import javax.ws.rs.core.Response;

import in.benchresources.cdm.city.CityListType;
import in.benchresources.cdm.city.CityType;

public interface CityService {
    public CityType getCityInfo(int cityId);
    public Response updateCityInfo(CityType cityType);
    public Response deleteCityInfo(int cityId);
    public Response createOrSaveCityInfo(CityType cityType);
	public CityListType getAllCities();
}
