package com.dexusint.resource;

import java.util.List;
import java.util.ArrayList;

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
import com.dexusint.model.City;


@Component
@Path("/cityservice")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;
	
	
	@GET
	@Path("getallcities")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<City> getAllCities() {

	    List<City> lstCities = cityDAO.getAllCities();
	    List<City> returnCities = new ArrayList<City>();

	    for(City city : lstCities){

	        returnCities.add(city); // add to bookListType
	    }
	    return returnCities;
	}
}


