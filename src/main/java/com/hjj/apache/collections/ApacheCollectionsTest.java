package com.hjj.apache.collections;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

public class ApacheCollectionsTest {

	@Test
	public void hashBagTest() {
		Bag<String> bag = new HashBag<>();
		bag.add("a", 2);
		bag.add("b");
		bag.add("c");
		bag.add("d", 3);
		System.out.println(bag.size());
		System.out.println("d is present " + bag.getCount("d") + " times.");
		System.out.println("bag: " + bag);
		System.out.println("Unique Set: " + bag.uniqueSet());
		bag.remove("d", 2);
		System.out.println("2 occurences of d removed from bag: " + bag);
		System.out.println("d is present " + bag.getCount("d") + " times.");
		System.out.println("bag: " + bag);
		System.out.println("Unique Set: " + bag.uniqueSet());
	}
	
	
}
