package com.hjj.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnectionImpl implements DBConnection {
	private static Logger logger = Logger.getLogger(DBConnectionImpl.class);
	private static Properties properties = new Properties();
	private static String dbDriver;
	private static String dbUrl;
	private static String dbName;
	private static String dbPassword;
	private static Connection con = null;
	
	private static class DBConnectionHolder{
		private static final DBConnectionImpl dbConnection = new DBConnectionImpl();
	}
	
	private DBConnectionImpl(){
		
	}
	
	public static DBConnectionImpl getInstance(){
		return DBConnectionHolder.dbConnection;
	}
	
	static {
		InputStream is = DBConnection.class.getResourceAsStream("/mysql.properties");
		try {
			properties.load(is);
		} catch (Exception e) {
			logger.error("IOException: " + e.getMessage());
		}
	}
	
	@Override
	public void dbInit() {
		
	}
	
	@Override
	public Connection getConnection() {
		
		dbDriver = (String) properties.get("mysqlpackage");
		dbUrl = (String) properties.get("mysqlurl");
		dbName = (String) properties.get("mysqlname");
		dbPassword = (String) properties.get("mysqlpassword");
		
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbName, dbPassword);
//			logger.info("---> 数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
