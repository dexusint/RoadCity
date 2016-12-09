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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dexusint.road.dao.RoadDAO;
import com.dexusint.road.model.Road;

import in.benchresources.cdm.road.RoadListType;
import in.benchresources.cdm.road.RoadType;

@Component
@Path("/roadservice")
public class RoadServiceImpl implements RoadService {

    @Autowired
    private RoadDAO roadDAO;
    
    @POST
    @Path("addroad")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createOrSaveRoadInfo(RoadType roadType) {
 
        // unwrap roadType and set in Model object Road
        Road newRoad = new Road();
        newRoad.setRoadId(roadType.getRoadId());
        newRoad.setRoadIndex(roadType.getRoadIndex());
        newRoad.setRoadTitle(roadType.getRoadTitle());
        newRoad.setCityBegId(roadType.getCityBegId());
        newRoad.setCityEndId(roadType.getCityEndId());
        String result = roadDAO.insertNewRoadInfo(newRoad);
        
        return Response.status(200).entity(result).build();
    }
    
    @PUT
    @Path("updateroad")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateRoadInfo(RoadType roadType) {
 
        // unwrap roadType and set in Model object Road
        Road modifyRoad = new Road();
        modifyRoad.setRoadId(roadType.getRoadId());
        modifyRoad.setRoadTitle(roadType.getRoadTitle());
        modifyRoad.setRoadIndex(roadType.getRoadIndex());
        modifyRoad.setCityBegId(roadType.getCityBegId());
        modifyRoad.setCityEndId(roadType.getCityEndId());
 
        // update road info & return SUCCESS message
        String result = roadDAO.updateRoadInfo(modifyRoad);
        
        return Response.status(200).entity(result).build();
    }
 
    @DELETE
    @Path("deleteroad/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public Response deleteRoadInfo(@PathParam("id") int roadId) {
 
        // delete road info & return SUCCESS message
    	Road removeRoad = new Road();
        removeRoad.setRoadId(roadId);
        String result = roadDAO.removeRoadInfo(removeRoad);
        
        return Response.status(200).entity(result).build();
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
        roadType.setRoadIndex(getRoad.getRoadIndex());
        roadType.setRoadTitle(getRoad.getRoadTitle());
        roadType.setCityBegId(getRoad.getCityBegId());
        roadType.setCityEndId(getRoad.getCityEndId());
        return roadType;
    }
	
	@GET
	@Path("getallroads")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RoadListType getAllRoads() {

	    List<Road> lstRoads = roadDAO.getAllRoads();
	    RoadListType returnRoads = new RoadListType();

	    for(Road road : lstRoads){
            RoadType roadType = new RoadType();
            roadType.setRoadId(road.getRoadId());
            roadType.setRoadIndex(road.getRoadIndex());
            roadType.setRoadTitle(road.getRoadTitle());
            roadType.setCityBegId(road.getCityBegId());
            roadType.setCityEndId(road.getCityEndId());
            returnRoads.getRoadType().add(roadType); // add to bookListType
		    }
		
	    return returnRoads;
	}
}
