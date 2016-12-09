package com.dexusint.road.resource;

import javax.ws.rs.core.Response;

import in.benchresources.cdm.road.RoadListType;
import in.benchresources.cdm.road.RoadType;

public interface RoadService {
    public RoadType getRoadInfo(int roadId);
    public Response updateRoadInfo(RoadType roadType);
    public Response deleteRoadInfo(int roadId);
    public Response createOrSaveRoadInfo(RoadType roadType);
	public RoadListType getAllRoads();
}