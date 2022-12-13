package login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Utility;

public class LoginWebPage_TestNG 
{
	@FindBy (xpath="//input[@type='checkbox']") private WebElement chbox;
	@FindBy (xpath="//input[@type='email']") private WebElement id;
	@FindBy (xpath="//input[@class='password']") private WebElement pass;
	@FindBy (xpath="//button[@type='submit']") private WebElement lgbutton;
	
	
	public LoginWebPage_TestNG(WebDriver Driver)
	{
		PageFactory.initElements(Driver, this);
	}
//	verify Title
	public String titalVerify() throws EncryptedDocumentException, IOException
	{
		String expTitle = Utility.excelString("Sheet1", 2, 1);           //  getting in Test class
		return expTitle;
	}
//	Verify Checkbox is selected or not
	public void checkboxVerify() throws  EncryptedDocumentException, IOException
	{
		boolean expCBresult = Utility.excelBoolean("Sheet1", 2, 2);
//		chbox.click();									
		boolean actCBresult = chbox.isSelected();		
		Assert.assertEquals(expCBresult, actCBresult, "CheckBox is already Selected");
			
	}
//	enter email
	public void enterUN() throws InterruptedException, EncryptedDocumentException, IOException
	{
		id.clear();
		id.sendKeys(Utility.excelString("Sheet1", 2, 4));     			  //id.sendKeys("admin@yourstore.com");
	}
	
	public void enterPass() throws InterruptedException, EncryptedDocumentException, IOException
	{
//	enter password
		pass.clear();
		pass.sendKeys(Utility.excelString("Sheet1", 2, 5));				//pass.sendKeys("admin");
	}
	
	public void clickLogin() throws InterruptedException
	{
		lgbutton.click();;				
	}
	
}
