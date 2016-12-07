package com.dexusint.road.resource;

import in.benchresources.cdm.road.RoadListType;
import in.benchresources.cdm.road.RoadType;

public interface RoadService {
    public RoadType getRoadInfo(int roadId);
    public String updateRoadInfo(RoadType roadType);
    public String deleteRoadInfo(int roadId);
    public String createOrSaveRoadInfo(RoadType roadType);
	public RoadListType getAllRoads();
}