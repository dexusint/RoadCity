package com.dexusint;

import java.net.URI;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Simple test to check "Hello World!" is being returned from the helloworld resource.
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class HelloWorldTest extends JerseyTest {

    @Override
    protected Application configure() {
    	return new MyApplication();
    }
//
//    @Override
//    protected URI getBaseUri() {
//        return UriBuilder.fromUri(super.getBaseUri()).path("helloworld-webapp").build();
//    }

    @Test
    public void testClientStringResponse() {
        String s = target().path("spring-hello").request().get(String.class);
        assertEquals("world", s);
    }
}