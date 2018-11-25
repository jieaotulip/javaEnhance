package com.hjj.base.compara;

import java.util.Comparator;

public class ComparatorDomain implements Comparator<ComparableDomain> {
	public int compare(ComparableDomain o1, ComparableDomain o2) {
		if (o1.getStr().compareTo(o2.getStr()) > 0) {
			return 1;
		} else if (o1.getStr().compareTo(o2.getStr()) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}
