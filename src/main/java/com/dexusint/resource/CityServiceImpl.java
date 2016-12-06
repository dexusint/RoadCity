package com.dexusint.resource;

import java.util.List;
import in.benchresources.cdm.city.CityType;
import in.benchresources.cdm.city.CityListType;

import com.dexusint.model.City;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.dexusint.dao.CityDAO;
//import com.dexusint.model.City;


@Component
@Path("/cityservice")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;
	
	@GET
	@Path("getallcities")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CityListType getAllCities() {

	    List<City> lstCities = cityDAO.getAllCities();
	    CityListType returnCities = new CityListType();

	    for(City city : lstCities){
            CityType cityType = new CityType();
            cityType.setCityId(city.getCityId());
            cityType.setCityTitle(city.getCityTitle());
	        returnCities.getCityType().add(cityType); // add to bookListType
	    }
	    return returnCities;
	}
}


