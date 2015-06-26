/**  
 * @Project: crimeSystem_rest
 * @Title:   ExceptionMapperSupport.java
 * @Package  com.founder.dataCenter.crime.interceptor
 * @Description: TODO
 * @author qs
 * @date 2015-4-29 下午4:34:51
 * @Copyright: 2015 
 * @version V1.2  
 */

package com.founder.dataCenter.crime.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;

import com.founder.dataCenter.crime.exception.BaseException;
import com.founder.dataCenter.crime.exception.ExceptionCode;

/**
 * @ClassName ExceptionMapperSupport
 * @Description TODO
 * @author qs
 * @param <E>
 * @date 2015-4-29
 */
@Provider
public class ExceptionMapperSupport implements ExceptionMapper<Exception> {

	private static final Logger LOGGER = Logger.getLogger(ExceptionMapperSupport.class);

	private static final String CONTEXT_ATTRIBUTE = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;

	@Context
	private HttpServletRequest request;

	@Context
	private ServletContext servletContext;

	/*
	 * (非 Javadoc) 
	 * <p>Title: toResponse</p> 
	 * <p>Description: </p> 
	 * @param exception
	 * @return 异常处理后的Response对象
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	
	public Response toResponse(Exception exception) {
		String message = ExceptionCode.INTERNAL_SERVER_ERROR;
		Status statusCode = Status.INTERNAL_SERVER_ERROR;
		WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(CONTEXT_ATTRIBUTE);
		// 处理checked exception
		if (exception instanceof BaseException) {
			BaseException baseException = (BaseException) exception;
			String code = baseException.getCode();
			Object[] args = baseException.getValues();
			message = context.getMessage(code, args, exception.getMessage(),request.getLocale());
		} else if (exception instanceof NotFoundException) {
			message = ExceptionCode.REQUEST_NOT_FOUND;
			statusCode = Status.NOT_FOUND;
		}
		// checked exception和unchecked exception均被记录在日志里
		LOGGER.error(message, exception);
		return Response.ok(message, MediaType.TEXT_PLAIN).status(statusCode).build();
	}
}
