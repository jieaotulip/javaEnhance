package com.hjj.test;

import org.junit.Assert;
import org.junit.Test;

import com.hjj.maven.App;

public class AppTest {
	
	@Test
	public void testLenthOfTheUniqueKey(){
		App app = new App();
		Assert.assertEquals(36, app.generateUniqueKey().length());
	}
}
