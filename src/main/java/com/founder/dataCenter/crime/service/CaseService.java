/**  
 * @Project: crimeSystem_rest
 * @Title:   CaseService.java
 * @Package  com.founder.dataCenter.crime.service
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午5:25:22
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.dataCenter.crime.dao.CaseDao;
import com.founder.dataCenter.crime.exception.ServiceException;
import com.founder.dataCenter.crime.pojo.CaseBean;
import com.founder.dataCenter.crime.util.Tools;

/**
 * @ClassName   CaseService
 * @Description TODO
 * @author qs
 * @date 2015-4-29
 */
@Service
public class CaseService {

	private static final Logger LOGGER = Logger.getLogger(CaseService.class);
	
	@Autowired
	private CaseDao caseDao;
	
	/**
	 * 
	 * @Title: getCaseById 
	 * @Description: TODO
	 * @param @param caseId
	 * @param @return     
	 * @return CaseBean     
	 * @throws
	 */
	public CaseBean getCaseById(final String ajbh) {
		try {
			return caseDao.findById(ajbh);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return new CaseBean();
		}
	}
	
	/**
	 * 
	 * @Title: getCasesByRange 
	 * @Description: 分页查询
	 * @param @param from
	 * @param @param to
	 * @param @return     
	 * @return List<CaseBean>     
	 * @throws
	 */
	public List<CaseBean> getCasesByRange(final int from, final int to) {
		List<CaseBean> caseList = (List<CaseBean>)caseDao.findAll(true, from, to);
		if (caseList.size() == 0) {
			throw new ServiceException("没有查询到案件信息!");
		} else {
			return caseList;
		}
	}
}
