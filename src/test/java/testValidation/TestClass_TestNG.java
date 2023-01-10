package testValidation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import dashboard.Dashboard_TestNG;
import login.LoginWebPage_TestNG;


public class TestClass_TestNG  extends BaseClass
{
	private static Logger lg = (Logger) LogManager.getLogger(TestClass_TestNG.class.getName());
	LoginWebPage_TestNG lp;
	Dashboard_TestNG d;
	@BeforeClass 
	public void BrowserOpen()
	{	
		lg.info("Getting Driver");
		chrome();
		lp = new LoginWebPage_TestNG(driver);
		d = new Dashboard_TestNG(driver);
		lg.info("succesfully opened Driver and and get web");
		}
	@Test (priority = 1)
	public void TitalValidation() throws EncryptedDocumentException, IOException
	{
		lg.info("Verifying Title");
		String actTitle = driver.getTitle();
		String expTitle = lp.titalVerify();
		Assert.assertEquals(expTitle, actTitle, "Tital is not verified");
		Reporter.log("Tital is Verified");
		lg.info("Tital is Verified");
	}
	@Test (priority = 2)
	public void CheckBoxValidation() throws EncryptedDocumentException, IOException
	{
		lg.info("Verifying checkBox");
		lp.checkboxVerify();
		lg.info("checkBox is Verified");
		
	}
	@Test (priority = 3, groups = "Regression")
	public void LogInValidation() throws EncryptedDocumentException, InterruptedException, IOException
	{
		lp.enterUN();
		lg.info("Entered User Name");
		lp.enterPass();
		lg.info("Entered Password");
		lp.clickLogin();
		lg.info("Clicked on login button");
	}
	@Test (dependsOnMethods = {"LogInValidation"})
	public void LogoValidation() throws EncryptedDocumentException, IOException
	{
		d.LogoVerify(driver);
	}
	@AfterClass
	public void BrowseClose()
	{
		driver.close();
		lg.info("Logo is Verified");
	}

}
