package com.hjj.base.compara;

public class TestMain {
	public static void main(String[] args) {
		ComparableDomain d1 = new ComparableDomain("c");
		ComparableDomain d2 = new ComparableDomain("c");
		ComparableDomain d3 = new ComparableDomain("b");
		ComparableDomain d4 = new ComparableDomain("d");
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.compareTo(d3));
		System.out.println(d1.compareTo(d4));
	}
}
