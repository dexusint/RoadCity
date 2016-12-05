package com.dexusint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "CITIES")
public class City {
	@Id
    @GeneratedValue
    @Column(name = "CITY_ID")
    private int cityId;
 
    @Column(name= "TITLE")
    private String cityTitle;
 
    // getters & setters
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public String getCityTitle() {
        return cityTitle;
    }
    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }    
}