package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
		public static WebDriver d;
		public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	    d=new ChromeDriver();
	    d.manage().window().maximize();
	    d.manage().deleteAllCookies();
	    d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    d.get("https://www.google.com/");

	}
		public void failed() throws IOException {
			File f=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("C:\\Users\\Mashuda\\eclipse-workspace\\SeleniumProject\\TestNgMaven\\screenshots\\testfailure.png"));
		}
	}


