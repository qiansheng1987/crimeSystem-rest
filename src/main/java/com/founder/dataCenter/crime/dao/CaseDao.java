/**  
 * @Project: crimeSystem_rest
 * @Title:   CaseDao.java
 * @Package  com.founder.dataCenter.crime.dao
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午5:21:27
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.founder.dataCenter.crime.exception.DaoException;
import com.founder.dataCenter.crime.pojo.CaseBean;

/**
 * @ClassName   CaseDao
 * @Description 案件相关查询
 * @author qs
 * @date 2015-4-29
 */

@Repository
public class CaseDao {

	private static final Logger LOGGER = Logger.getLogger(CaseDao.class);
	
	@PersistenceContext
	private EntityManager entityManeger;
	
	public CaseDao() {
	}
	
	/**
	 * 
	 * @Title: findById 
	 * @Description: 根据案件编号查询
	 * @param  ajbh
	 * @param @return     
	 * @return CaseBean     
	 * @throws
	 */
	public CaseBean findById(final String ajbh) {
        try {
        	return entityManeger.find(CaseBean.class, ajbh);
        } catch (final Exception e) {
            LOGGER.error(e);
            throw new DaoException(e.getMessage());
        }
    }
	
	/**
	 * 
	 * @Title: findAll 
	 * @Description: 分页查询
	 * @param  isPaging TRUE为分页查询,false为全部查询
	 * @param  firstResult
	 * @param  maxResults
	 * @param  @return     
	 * @return List<Book>     
	 * @throws
	 */
	public List<CaseBean> findAll(final boolean isPaging, final int firstResult, final int maxResults) {
        final CriteriaBuilder cb = entityManeger.getCriteriaBuilder();
        final CriteriaQuery<CaseBean> cq = cb.createQuery(CaseBean.class);
        final TypedQuery<CaseBean> query = entityManeger.createQuery(cq);
        if (isPaging) {
        	query.setMaxResults(maxResults);
        	query.setFirstResult(firstResult);
        }
        return query.getResultList();
    }
}
