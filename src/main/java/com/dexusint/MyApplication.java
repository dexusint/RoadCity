package com.dexusint;

//import com.dexusint.city.resource.*;
//import com.dexusint.road.resource.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
@ApplicationPath("/")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        // register root resource
        classes.add(RoadCityService.class);
        //classes.add(CityServiceImpl.class);
        //classes.add(RoadServiceImpl.class);
        return classes;
    }
}