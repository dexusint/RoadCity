package com.dexusint;

import com.dexusint.city.resource.*;
import com.dexusint.road.resource.*;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.grizzly2.servlet.GrizzlyWebContainerFactory;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import org.glassfish.grizzly.http.server.HttpServer;

/**
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/helloworld-webapp/");
    public static final String ROOT_PATH = "helloworld";

    public static void main(String[] args) {
        try {
            System.out.println("\"Hello World\" Jersey Example App");

            Map<String, String> initParams = new HashMap<>();
            initParams.put(
                    ServerProperties.PROVIDER_PACKAGES,
                    RoadCityService.class.getPackage().getName());
            initParams.put(
                    ServerProperties.PROVIDER_PACKAGES,
                    CityServiceImpl.class.getPackage().getName());
            final HttpServer server = GrizzlyWebContainerFactory.create(BASE_URI, ServletContainer.class, initParams);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    server.shutdownNow();
                }
            }));

            System.out.println(String.format("Application started.%nTry out %s%s%nStop the application using CTRL+C",
                    BASE_URI, ROOT_PATH));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}