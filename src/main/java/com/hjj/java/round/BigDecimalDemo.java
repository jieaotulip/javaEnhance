package com.hjj.java.round;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalDemo {
	public static void main(String[] args) {
		// 建立货币格式化的引用
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		// 建立百分比格式化的引用
		NumberFormat percent = NumberFormat.getPercentInstance();
		// 百分比小数点最多3位
		percent.setMaximumFractionDigits(3);
		BigDecimal loanAmount = new BigDecimal("15000.48"); 
		BigDecimal interestRate = new BigDecimal("0.008"); 
		BigDecimal interest = loanAmount.multiply(interestRate);
		System.out.println("贷款金额： " + currency.format(loanAmount));
		System.out.println("利息： " + currency.format(interest));
		System.out.println("利率： " + percent.format(interestRate));
	}
}
