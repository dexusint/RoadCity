package com.dexusint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("spring-hello")
@Component
public class RoadCityServiceImpl implements RoadCityService {
    
	@Autowired
    private HttpServletRequest servletRequest;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "world";
    }
}
