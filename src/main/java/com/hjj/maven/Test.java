package com.hjj.maven;

import org.apache.log4j.Logger;

public class Test {
	private static Logger logger = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
//		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
//		System.out.println("hello world!");
		logger.info("Test.main()");
	}
}
