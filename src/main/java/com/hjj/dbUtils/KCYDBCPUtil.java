package com.hjj.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.log4j.Logger;

/**
 * DBCP配置类
 * @author Administrator
 *
 */
public class KCYDBCPUtil {
	private static Logger logger = Logger.getLogger(KCYDBCPUtil.class);
	private static Properties properties = new Properties();
	private static DataSource dataSource;
	// 加载DBCP配置文件
	static {
		InputStream is = KCYDBCPUtil.class.getResourceAsStream("/dbcp.properties");
		try {
			properties.load(is);
		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
		}
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			logger.error("Exception: " + e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			logger.error("SQLException: " + e.getMessage());
		}
		return connection;
	}
	
}
