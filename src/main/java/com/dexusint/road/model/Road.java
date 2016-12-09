package com.dexusint.road.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "ROADS")
public class Road {
	@Id
    @GeneratedValue
    @Column(name = "ROAD_ID")
    private int roadId;
 
    @Column(name= "ROAD_INDEX")
    private int roadIndex;
 
    @Column(name= "ROAD_TITLE")
    private String roadTitle;
    
    @Column(name= "CITY_BEG_ID")
    private int cityBegId;
    
    @Column(name= "CITY_END_ID")
    private int cityEndId;
 
    // getters & setters
    public int getRoadId() {
        return roadId;
    }
    public void setRoadId(int roadId) {
        this.roadId = roadId;
    }
    public int getRoadIndex() {
        return roadIndex;
    }
    public void setRoadIndex(int roadIndex) {
        this.roadIndex = roadIndex;
    }
    public String getRoadTitle() {
        return roadTitle;
    }
    public void setRoadTitle(String roadTitle) {
        this.roadTitle = roadTitle;
    }
    
    public int getCityBegId() {
        return cityBegId;
    }
    public void setCityBegId(int cityBegId) {
        this.cityBegId = cityBegId;
    }
    
    public int getCityEndId() {
        return cityEndId;
    }
    public void setCityEndId(int cityEndId) {
        this.cityEndId = cityEndId;
    }  
}


