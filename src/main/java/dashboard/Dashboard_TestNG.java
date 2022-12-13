package dashboard;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Utility;

public class Dashboard_TestNG 
{
	@FindBy (xpath="(//img[@alt='logo.png'])[2]") private WebElement logo;
	public Dashboard_TestNG(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	verify Logo after login [DashBoard]
	public void LogoVerify(WebDriver driver) throws  EncryptedDocumentException, IOException
	{
		boolean explogo = Utility.excelBoolean("Sheet1", 2, 3);
		boolean actlogo = logo.isDisplayed();
		Assert.assertEquals(explogo, actlogo, "Logo is not Displayde");
		Utility.screenShot(driver);
	}


}
