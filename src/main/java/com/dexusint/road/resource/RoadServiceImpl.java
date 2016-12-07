package com.dexusint.road.resource;

import java.util.List;

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

import com.dexusint.road.dao.RoadDAO;
import com.dexusint.road.model.Road;

import in.benchresources.cdm.road.RoadListType;
import in.benchresources.cdm.road.RoadType;

@Component
@Path("/roadservice")
public class RoadServiceImpl {

 @Autowired
    private RoadDAO roadDAO;
    
    @POST
    @Path("addroad")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String createOrSaveRoadInfo(RoadType roadType) {
 
        // unwrap roadType and set in Model object Road
        Road newRoad = new Road();
        newRoad.setRoadId(roadType.getRoadId());
        newRoad.setRoadTitle(roadType.getTitle());
        newRoad.setRoadIndex(roadType.getIndex());
        newRoad.setCityBeg(roadType.getCityBeg());
        newRoad.setCityEnd(roadType.getCityEnd());
        return roadDAO.insertNewRoadInfo(newRoad);
    }
    
    @PUT
    @Path("updateroad")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateRoadInfo(RoadType roadType) {
 
        // unwrap roadType and set in Model object Road
        Road modifyRoad = new Road();
        modifyRoad.setRoadId(roadType.getRoadId());
        modifyRoad.setRoadTitle(roadType.getTitle());
        modifyRoad.setRoadIndex(roadType.getIndex());
        modifyRoad.setCityBeg(roadType.getCityBeg());
        modifyRoad.setCityEnd(roadType.getCityEnd());
 
        // update road info & return SUCCESS message
        return roadDAO.updateRoadInfo(modifyRoad);
    }
 
    @DELETE
    @Path("deleteroad/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String deleteRoadInfo(@PathParam("id") int roadId) {
 
        // delete road info & return SUCCESS message
    	Road removeRoad = new Road();
        removeRoad.setRoadId(roadId);
        return roadDAO.removeRoadInfo(removeRoad);
    }
    
    @GET
    @Path("getroad/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RoadType getRoadInfo(@PathParam("id") int roadId) {
 
        // retrieve road information based on the id supplied in the formal argument
        Road getRoad = roadDAO.getRoadInfo(roadId);
 
        RoadType roadType = new RoadType();
        roadType.setRoadId(getRoad.getRoadId());
        roadType.setIndex(getRoad.getRoadIndex());
        roadType.setTitle(getRoad.getRoadTitle());
        roadType.setCityBeg(getRoad.getCityBeg());
        roadType.setCityEnd(getRoad.getCityEnd());
        return roadType;
    }
	
	@GET
	@Path("getallroads")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RoadListType getAllCities() {

	    List<Road> lstCities = roadDAO.getAllCities();
	    RoadListType returnCities = new RoadListType();

	    for(Road road : lstCities){
            RoadType roadType = new RoadType();
            roadType.setRoadId(road.getRoadId());
            roadType.setIndex(road.getRoadIndex());
            roadType.setTitle(road.getRoadTitle());
            roadType.setCityBeg(road.getCityBeg());
            roadType.setCityEnd(road.getCityEnd());
	        returnCities.getRoadType().add(roadType); // add to bookListType
		    }
		    return returnCities;
		}
}
