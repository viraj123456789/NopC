package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browse_Launch {

	public static void main(String[] args) {
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--remote-allow-origins=*");
//		WebDriver driver =new ChromeDriver(option);
//		WebDriver driver = new ChromeDriver() ;
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}

}
