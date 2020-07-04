import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapExample {

	public static void main(String[] args) {
		 WebDriver d;
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	        d=new ChromeDriver();
	        d.manage().window().maximize();
			d.manage().deleteAllCookies();
			d.get("https://classic.freecrm.com/index.html");
			//String get_Admin_credintial=getCredintials().get("Admin");
			d.findElement(By.xpath("//input[@name='username']")).sendKeys(getUserName("Customer"));
			d.findElement(By.xpath("//input[@name='password']")).sendKeys(getPasswordName("Customer"));
	}
	
	public static HashMap<String,String> getCredintials() {
		HashMap<String,String> hs=new HashMap<String, String>();
		hs.put("Admin", "Admin:Admin@123");
		hs.put("Customer","Cusomer:CUstomer@123");
		hs.put("Distributer","Distributer:Distributer@123");
		return hs;
	}
	public static String getUserName(String role)
	    {
		String credentials=getCredintials().get(role); 
		return credentials.split(":")[0];
        }
	public static String getPasswordName(String role)
    {
	String credentials=getCredintials().get(role); 
	return credentials.split(":")[1];
    }
}