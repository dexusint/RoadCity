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
 
    @Column(name= "INDEX")
    private int roadIndex;
 
    @Column(name= "TITLE")
    private String roadTitle;
    
    @Column(name= "CITY_BEG")
    private String cityBeg;
    
    @Column(name= "CITY_END")
    private String cityEnd;
 
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
    
    public String getCityBeg() {
        return cityBeg;
    }
    public void setCityBeg(String cityBeg) {
        this.cityBeg = cityBeg;
    }
    
    public String getCityEnd() {
        return cityEnd;
    }
    public void setCityEnd(String cityEnd) {
        this.cityEnd = cityEnd;
    }  
}


