package com.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Custom_Listener.class)
public class ScreenShotTest extends TestBase{
	
	@BeforeTest
	public void setUp() {
		initialization();
		
	}
	@AfterMethod
	public void tearDown() {
		d.quit();
		
	}
	@Test
	public void ScreenShotTest() {
		Assert.assertEquals(true, false);
		
	}
}
