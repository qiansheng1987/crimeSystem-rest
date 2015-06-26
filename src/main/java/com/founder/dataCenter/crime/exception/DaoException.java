/**  
 * @Project: crimeSystem_rest
 * @Title:   DaoException.java
 * @Package  com.founder.dataCenter.crime.exception
 * @Description: 数据访问层异常
 * @author qs
 * @date 2015-4-29 下午4:19:31
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.exception;

/**
 * @ClassName   DaoException
 * @Description 数据访问层异常
 * @author qs
 * @date 2015-4-29
 */

public class DaoException extends BaseException {
	
	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 1541874818801328069L;
	
	/**
	 * Constructors
	 * @param code 错误代码
	 */
	public DaoException(String code) {
		super(code, null, code, null);
	}

	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code 错误代码
	 */
	public DaoException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * Constructors
	 * @param code 错误代码
	 * @param values 一组异常信息待定参数
	 */
	public DaoException(String code, Object[] values) {
		super(code, null, code, values);
	}

	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code 错误代码
	 * @param values 一组异常信息待定参数
	 */
	public DaoException(Throwable cause, String code, Object[] values) {
		super(code, null, code, values);
	}
	
	/**
	 * Constructors
	 * @param cause 异常接口
	 * @param code 错误代码
	 * @param values 一组异常信息待定参数
	 */
	public DaoException(String message, Throwable cause, String code, Object[] values) {
		super(message, cause, code, values);
	}

}
