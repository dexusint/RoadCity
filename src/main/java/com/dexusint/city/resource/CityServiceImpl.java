package com.dexusint.city.resource;

import java.util.List;
import in.benchresources.cdm.city.CityType;
import in.benchresources.cdm.city.CityListType;

import com.dexusint.city.model.City;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.dexusint.city.dao.CityDAO;
//import com.dexusint.model.City;


@Component
@Path("/cityservice")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;
    
    @POST
    @Path("addcity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createOrSaveCityInfo(CityType cityType) {
 
        // unwrap cityType and set in Model object City
        City newCity = new City();
        newCity.setCityId(cityType.getCityId());
        newCity.setCityTitle(cityType.getCityTitle());
        String result = cityDAO.insertNewCityInfo(newCity);
        
        return Response.status(200).entity(result).build();
    }
    
    @PUT
    @Path("updatecity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateCityInfo(CityType cityType) {
 
        // unwrap cityType and set in Model object City
        City modifyCity = new City();
        modifyCity.setCityId(cityType.getCityId());
        modifyCity.setCityTitle(cityType.getCityTitle());
 
        // update city info & return SUCCESS message
        String result = cityDAO.updateCityInfo(modifyCity);
        
        return Response.status(200).entity(result).build();
    }
 
    @DELETE
    @Path("deletecity/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteCityInfo(@PathParam("id") int cityId) {
 
        // delete city info & return SUCCESS message
    	City removeCity = new City();
        removeCity.setCityId(cityId);
        String result = cityDAO.removeCityInfo(removeCity);
        
        return Response.status(200).entity(result).build();
    }
    
    @GET
    @Path("getcity/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public CityType getCityInfo(@PathParam("id") int cityId) {
 
        // retrieve city information based on the id supplied in the formal argument
        City getCity = cityDAO.getCityInfo(cityId);
 
        CityType cityType = new CityType();
        cityType.setCityId(getCity.getCityId());
        cityType.setCityTitle(getCity.getCityTitle());
        return cityType;
    }
	
	@GET
	@Path("getallcities")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
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


