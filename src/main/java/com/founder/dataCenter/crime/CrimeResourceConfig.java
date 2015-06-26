package com.founder.dataCenter.crime;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.message.MessageProperties;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.founder.dataCenter.crime.filter.CrimeCrossDomainFilter;
import com.founder.dataCenter.crime.resource.CaseResource;

/**
 * 
 * @ClassName   CrimeResourceConfig
 * @Description TODO
 * @author qs
 * @date 2015-4-29
 */

@ApplicationPath("/webapi/*")
public class CrimeResourceConfig extends ResourceConfig {
	
    /**
     * <p>Constructor for CrimeResourceConfig.</p>
     */
    public CrimeResourceConfig() {
        packages("com.founder.dataCenter.crime");
        register(CaseResource.class);
        register(CrimeCrossDomainFilter.class);
        property(ServerProperties.WADL_FEATURE_DISABLE, false);//去除wadl自动生成的功能。
        property(MessageProperties.XML_SECURITY_DISABLE, false);//去除当属性或者元素过多时报well-formed-ness error
    }  
}