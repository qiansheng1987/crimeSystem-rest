/**  
 * @Project: crimeSystem_rest
 * @Title:   CrimeCrossDomainFilter.java
 * @Package  com.founder.dataCenter.crime.filter
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午4:40:12
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import com.founder.dataCenter.crime.util.Logger;

/**
 * @ClassName   CrimeCrossDomainFilter
 * @Description TODO
 * @author qs
 * @date 2015-4-29
 */

public class CrimeCrossDomainFilter implements ContainerRequestFilter,
	ContainerResponseFilter {
	
	/* (非 Javadoc) 
	 * <p>Title: filter</p> 
	 * <p>Description: </p> 
	 * @param requestContext
	 * @param responseContext
	 * @throws IOException 
	 * @see javax.ws.rs.container.ContainerResponseFilter
	 * 	#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext) 
	 */
	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		//request.setCharacterEncoding("GBK");
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseContext.getHeaders().add("Access-Control-Max-Age", "1209600");
	}

	/* (非 Javadoc) 
	 * <p>Title: filter</p> 
	 * <p>Description: </p> 
	 * @param requestContext
	 * @throws IOException 
	 * @see javax.ws.rs.container.ContainerRequestFilter
	 * 	#filter(javax.ws.rs.container.ContainerRequestContext) 
	 */

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		Logger.debug(requestContext.getHeaders().getFirst("Access-Control-Allow-Origin"));
	}

}
