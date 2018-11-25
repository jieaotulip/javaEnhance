package com.hjj.java.round;

import java.math.BigDecimal;

public class BigDecimalComparableDemo {
	public static void main(String[] args) {
		BigDecimal value1 = new BigDecimal("15.3");
		BigDecimal value2 = new BigDecimal("15.2");
		System.out.println(value1.compareTo(value2));
		System.out.println(value1.compareTo(value1));
		System.out.println(value2.compareTo(value1));
	}
}
