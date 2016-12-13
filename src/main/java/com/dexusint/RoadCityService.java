package com.dexusint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("spring-hello")
@Component
public class RoadCityService {
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return new String("world");
    }
}
