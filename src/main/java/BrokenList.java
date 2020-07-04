import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenList {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver d;
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        d=new ChromeDriver();
        d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		List<WebElement> linklist=d.findElements(By.tagName("a"));
		linklist.addAll(d.findElements(By.tagName("img")));
		System.out.println(linklist.size());
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<linklist.size();i++) 
		{
			System.out.println(linklist.get(i).getAttribute("href"));
			if((linklist.get(i).getAttribute("href")!=null) &&(!linklist.get(i).getAttribute("href").contains("javascript"))) 
			       {
			activeLinks.add(linklist.get(i));
		           }
		}
		System.out.println(activeLinks.size());
		for(int j=0;j<activeLinks.size();j++) {
			HttpURLConnection connect=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connect.connect();
			String response=connect.getResponseMessage();
			connect.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+response);
		
		} 
		

	}

}
