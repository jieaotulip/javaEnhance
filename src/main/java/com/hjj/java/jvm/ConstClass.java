package com.hjj.java.jvm;

public class ConstClass {
	public static final String HELLO_WORLD = "hello world";
	static {
		System.out.println("ConstClass init");
	}
}
