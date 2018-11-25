package com.hjj.java.jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaculateTest {
	Calculate calculation = new Calculate();
	int sum = calculation.sum(2, 5);
	int testSum = 7;

	@Test
	public void testSum() {
		System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(sum, testSum);
	}
}
