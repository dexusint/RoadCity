package com.dexusint.road.dao;

import java.util.List;

import com.dexusint.road.model.Road;

public interface RoadDAO {
	public String insertNewRoadInfo(Road addRoad);
	public Road getRoadInfo(int cityId);
    public String updateRoadInfo(Road updateRoad);
    public String removeRoadInfo(Road removeRoad);
	public List<Road> getAllCities();
}
