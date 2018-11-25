package com.hjj.log4j;

import org.apache.log4j.Logger;

/**
 * Log4j设置日志内容
 * @author hjj
 *
 */
public class Log4jUtil {
	private static Logger logger = Logger.getLogger(Log4jUtil.class);
	
	public static void main(String[] args) {
		// 记录debug级别的信息
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.error("This is error message");
	}
}
