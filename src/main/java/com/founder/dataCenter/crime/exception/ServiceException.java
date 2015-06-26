/**  
 * @Project: crimeSystem_rest
 * @Title:   ServiceException.java
 * @Package  com.founder.dataCenter.crime.exception
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午4:25:21
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.exception;

/**
 * @ClassName   ServiceException
 * @Description TODO
 * @author qs
 * @date 2015-4-29
 */

public class ServiceException extends BaseException {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 6214760970204316247L;
	
	/**
	 * Constructors
	 * @param code 错误代码
	 */
	public ServiceException(String code) {
		super(code, null, code, null);
	}

	/**
	 * Constructors
	 * 
	 * @param cause 异常接口
	 * @param code 错误代码
	 */
	public ServiceException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * Constructors
	 * 
	 * @param code 错误代码
	 * @param values 一组异常信息待定参数
	 */
	public ServiceException(String code, Object[] values) {
		super(code, null, code, values);
	}

	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code  错误代码
	 * @param values 一组异常信息待定参数
	 */
	public ServiceException(Throwable cause, String code, Object[] values) {
		super(code, null, code, values);
	}

}
