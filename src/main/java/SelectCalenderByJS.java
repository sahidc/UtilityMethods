import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalenderByJS {

	

		public static void main(String[] args) {
			 WebDriver d;
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	        d=new ChromeDriver();
	        d.manage().window().maximize();
			d.manage().deleteAllCookies();
			d.get("https://www.spicejet.com/");
			WebElement date=d.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
			String Date="31-07-2020";
			selectDateByJS(d,date,Date);

		}
		
		public static void selectDateByJS(WebDriver d,WebElement element, String Date) {
			JavascriptExecutor js=((JavascriptExecutor)d);
			js.executeScript("arguments[0].setAttribute('value','"+Date+"');",element); 
		}

	}