package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 
{
	static String key = "webdriver.chrome.driver";
	static String url = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	static String value;
	protected static WebDriver driver = null;
	
	public static void browserOpen(String browserName) 
	{		
		if(browserName.equals("chrome"))
		{
			value = System.getProperty("user.dir")+"\\Softwares\\chromedriver.exe";
			System.setProperty(key, value );
			driver = new ChromeDriver();			
		}
		
		else if(browserName.equals("fireFox"))
		{
			value = System.getProperty("user.dir")+"\\Softwares\\geckodriver64.exe";
			System.setProperty(key,value);
			driver = new FirefoxDriver();  
		}
		
		else if(browserName.equals("edge"))
		{
			value = System.getProperty("user.dir")+"\\Softwares\\msedgedriver.exe";
			System.setProperty(key, value);
			driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	

}
