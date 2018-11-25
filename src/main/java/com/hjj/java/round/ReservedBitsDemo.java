package com.hjj.java.round;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ReservedBitsDemo {
	public static void main(String[] args) {
		test01();
	}

	public static void test01() {
		double f = 111231.5585;
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
		System.out.println(f1);
	}

	public static void test02() {
		DecimalFormat df = new DecimalFormat("#.00");
		df.format("111231.5585");
	}
}
