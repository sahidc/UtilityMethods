import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) {
		WebDriver d;
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        d=new ChromeDriver();
        d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
        d.findElement(By.xpath("//button[@id='menu1']")).click();
        List<WebElement> lst=d.findElements(By.xpath("//ul[contains(@class,'dropdown-menu test')]//li//a"));
        for(int i=0;i<lst.size();i++) {
        	System.out.println(lst.get(i).getText());
        	if(lst.get(i).getText().equals("JavaScript")) {
        		lst.get(i).click();
        	}
        }
        
	}

}
