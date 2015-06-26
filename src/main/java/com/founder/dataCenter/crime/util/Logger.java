package com.founder.dataCenter.crime.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

/**
 * 
 * @ClassName   Logger
 * @Description TODO
 * @author qs
 * @date 2015-4-29
 */
public class Logger {

	private static Log logger = LogFactory.getLog(Logger.class);

	private Logger() {
	}

	static {
		BasicConfigurator.configure();
	}

	public static void fatal(String message) {
		if (logger.isFatalEnabled()) {
			logger.fatal(message);
		}
	}

	public static void fatal(String message, Exception e) {
		if (logger.isFatalEnabled()) {
			logger.fatal(message + "\n" + e.getMessage());
		}
	}

	public static void info(String message) {
		if (logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	public static void info(String message, Exception e) {
		if (logger.isInfoEnabled()) {
			logger.info(message + "\n" + e.getMessage());
		}
	}

	public static void warn(String message) {
		if (logger.isWarnEnabled()) {
			logger.warn(message);
		}
	}

	public static void warn(String message, Exception e) {
		if (logger.isWarnEnabled()) {
			logger.warn(message + "\n" + e.getMessage());
		}
	}

	public static void error(String message) {
		if (logger.isErrorEnabled()) {
			logger.error(message);
		}
	}

	public static void error(String message, Exception e) {
		if (logger.isErrorEnabled()) {
			logger.error(message + "\n" + e.getMessage());
		}
	}

	public static void debug(String message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	public static void debug(String message, Exception e) {
		if (logger.isDebugEnabled()) {
			logger.debug(message + "\n" + e.getMessage());
		}
	}

}
