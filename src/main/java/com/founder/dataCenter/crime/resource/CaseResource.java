/**  
 * @Project: crimeSystem_rest
 * @Title:   CaseResource.java
 * @Package  com.founder.dataCenter.crime.resource
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午5:07:43
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.dataCenter.crime.constant.CrimeApi;
import com.founder.dataCenter.crime.pojo.CaseBean;
import com.founder.dataCenter.crime.service.CaseService;

/**
 * @ClassName   CaseResource
 * @Description 案件资源类
 * @author qs
 * @date 2015-4-29
 */
@Path(CrimeApi.CASE_PATH)
public class CaseResource {
	
	private static final Logger LOGGER = Logger.getLogger(CaseResource.class);
	
	@Autowired
	private CaseService caseService;
	
	/**
	 * 
	 * @Title: getBookByPath 
	 * @Description: 
	 * <p>
	 * 	根据案件编号查询
	 * 	查询格式：webapi/cases/J3204045808100000725
	 * </p>
	 * @param @param ajbh
	 * @param @return     
	 * @return CaseBean     
	 * @throws
	 */
	@Path("{ajbh:[a-zA-Z0-9]*}")
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    public CaseBean getCaseByPath(@PathParam("ajbh") final String ajbh) {
        final CaseBean caseBean = caseService.getCaseById(ajbh);
        CaseResource.LOGGER.debug(caseBean);
        return caseBean;
    }
	
	/**
	 * 
	 * @Title: getCasesByRange 
	 * @Description: 
	 * <p>
	 * 	分页查询
	 * 	查询格式：webapi/cases/1-1000
	 * </p>
	 * @param @param from
	 * @param @param to
	 * @param @return     
	 * @return List<CaseBean>     
	 * @throws
	 */
	@GET
	@Path("{from:[0-9]+}-{to:[0-9]+}")
	@Produces({MediaType.APPLICATION_JSON })
	public List<CaseBean> getCasesByRange(@PathParam("from") final int from,
				@PathParam("to") final int to) {
		List<CaseBean> caseList= (List<CaseBean>)caseService.getCasesByRange(from, to);
		return caseList;
	}
}
