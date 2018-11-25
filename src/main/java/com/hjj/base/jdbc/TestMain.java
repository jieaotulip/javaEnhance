package com.hjj.base.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TestMain {
	public static void main(String[] args) throws IOException {
//		ResourceBundle bundle = ResourceBundle.getBundle("mysql.properties");
//		System.out.println(bundle.getString("mysqlurl"));
		Properties properties = new Properties();
		InputStream is = ClassLoader.class.getResourceAsStream("/mysql.properties");
		properties.load(is);
		System.out.println(properties.get("mysqlurl"));
		is.close();
	}
}
