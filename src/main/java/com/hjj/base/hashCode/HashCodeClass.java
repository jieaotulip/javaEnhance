package com.hjj.base.hashCode;

public class HashCodeClass {
	private String str0;
	private double dou;
	private int int0;
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HashCodeClass) {
			HashCodeClass hcc = (HashCodeClass) obj;
			if (hcc.str0.equals(this.str0) && hcc.dou == this.dou && hcc.int0 == this.int0) {
				return true;
			}
			return false;
		}
		return false;
	}
}
