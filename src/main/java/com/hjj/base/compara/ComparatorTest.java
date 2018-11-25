package com.hjj.base.compara;

public class ComparatorTest {
	public static void main(String[] args) {
		ComparableDomain d1 = new ComparableDomain("c");
		ComparableDomain d2 = new ComparableDomain("c");
		ComparableDomain d3 = new ComparableDomain("b");
		ComparableDomain d4 = new ComparableDomain("d");
	    ComparatorDomain dc = new ComparatorDomain();
	    System.out.println(dc.compare(d1, d2));
	    System.out.println(dc.compare(d1, d3));
	    System.out.println(dc.compare(d1, d4));
	}
}
