package testValidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dashboard.Dashboard_TestNG;
import login.LoginWebPage_TestNG;

public class TestClass_TestNG  extends BaseClass
{
	LoginWebPage_TestNG lp;
	Dashboard_TestNG d;
	@BeforeClass 
	public void BrowserOpen()
	{	
		chrome();
		lp = new LoginWebPage_TestNG(driver);
		d = new Dashboard_TestNG(driver);
	}
	@Test (priority = 1)
	public void TitalValidation() throws EncryptedDocumentException, IOException
	{
		String actTitle = driver.getTitle();
		String expTitle = lp.titalVerify();
		Assert.assertEquals(expTitle, actTitle, "Tital is not verified");
	}
	@Test (priority = 2)
	public void CheckBoxValidation() throws EncryptedDocumentException, IOException
	{
		lp.checkboxVerify();
	}
	@Test (priority = 3)
	public void LogInValidation() throws EncryptedDocumentException, InterruptedException, IOException
	{
		lp.enterUN();
		lp.enterPass();
		lp.clickLogin();
	}
	@Test (dependsOnMethods = "LogInValidation")
	public void LogoValidation() throws EncryptedDocumentException, IOException
	{
		d.LogoVerify(driver);
	}
	@AfterClass
	public void BrowseClose()
	{
		driver.close();
	}

}
