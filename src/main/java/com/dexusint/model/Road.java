package com.dexusint.model;

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
}


