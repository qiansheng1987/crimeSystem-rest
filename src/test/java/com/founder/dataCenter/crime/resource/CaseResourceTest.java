package com.founder.dataCenter.crime.resource;


import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import com.founder.dataCenter.crime.pojo.CaseBean;


/**
 * Integration Test by Jersey Test Framework
 * 
 * @author qs
 *
 */
public class CaseResourceTest extends JerseyTest {
    private static final Logger LOGGER = Logger.getLogger(CaseResourceTest.class);
    private static final String BASEURI = "CrimeSystem_rest/webapi/cases/";
    static final String CONTAINER_GRIZZLY = "org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory";
    static final String CONTAINER_MEMORY = "org.glassfish.jersey.test.inmemory.InMemoryTestContainerFactory";
    static final String CONTAINER_JDK = "org.glassfish.jersey.test.jdkhttp.JdkHttpServerTestContainerFactory";
    static final String CONTAINER_SIMPLE = "org.glassfish.jersey.test.simple.SimpleTestContainerFactory";
   
    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(CaseResource.class);
    }

    @Test
    public void testgetCaseById() {
        
    	CaseResourceTest.LOGGER.debug(">>Test Path Get");
        final WebTarget pathTarget = target(CaseResourceTest.BASEURI + "J3204045808100000725");
        final Invocation.Builder invocationBuilder = pathTarget.request(MediaType.APPLICATION_JSON);
        final CaseBean result = invocationBuilder.get(CaseBean.class);
        CaseResourceTest.LOGGER.debug(result);
        Assert.assertNotNull(result.getAfdz());
        CaseResourceTest.LOGGER.debug("<<Test Path Get");
    }
}
