/**  
 * @Project: crimeSystem_rest
 * @Title:   BaseException.java
 * @Package  com.founder.dataCenter.crime.exception
 * @Description: 异常基类
 * @author qs
 * @date 2015-4-29 下午4:14:39
 * @Copyright: 2015 
 * @version V1.2  
*/

package com.founder.dataCenter.crime.exception;

/**
 * @ClassName   BaseException
 * @Description 异常基类
 * @author qs
 * @date 2015-4-29
 */

public class BaseException extends RuntimeException {

	/** 
	 * @Fields serialVersionUID :
	 */ 
	
	private static final long serialVersionUID = -6438587705014539296L;
	
	/*
	 *  messageKey
	 */
	private String code;
	
	/*
	 * message params
	 */
	private Object[] values;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}
	
	public BaseException(String message, Throwable cause, String code, Object[] values) {
		super(message, cause);
		this.code = code;
		this.values = values;
	}
}



































