package com.hjj.base.compara;

public class ComparableDomain implements Comparable<ComparableDomain> {
	private String str;
	public ComparableDomain(String str){
		this.str = str;
	}
	public int compareTo(ComparableDomain o) {
		if (this.str.compareTo(o.str) > 0) {
			return 1;
		} else if (this.str.compareTo(o.str) == 0) {
			return 0;
		} else if (this.str.compareTo(o.str) < 0) {
			return -1;
		}
		return 0;
	}
	public String getStr(){
		return str;
	}
}
