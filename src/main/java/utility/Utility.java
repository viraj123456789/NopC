package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	static Workbook wbf;
	
	public static String excelString(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData1.xlsx");
		wbf = WorkbookFactory.create(file);
		String StrinData = wbf.getSheet(SheetName).getRow(rowNo - 1).getCell(cellNo - 1).getStringCellValue();
		
		return StrinData;
	}
	
	public static boolean excelBoolean(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
//		FileInputStream file = new FileInputStream("D:\\Aspire\\Eclipse Files\\SeleniumAugust22\\TestData\\TestData1.xlsx");
//		wbf = WorkbookFactory.create(file);
		boolean booleanData = wbf.getSheet(SheetName).getRow(rowNo - 1).getCell(cellNo - 1).getBooleanCellValue();
		return booleanData;
	}
	public static double excelNumeric(String SheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
//		FileInputStream file = new FileInputStream("D:\\Aspire\\Eclipse Files\\SeleniumAugust22\\TestData\\TestData1.xlsx");
//		wbf = WorkbookFactory.create(file);
		double NumericData = wbf.getSheet(SheetName).getRow(rowNo - 1).getCell(cellNo - 1).getNumericCellValue();
		return NumericData;
	}
		
	public static void screenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String timestamp = d.toString().replace(" ", "_").replace(":", "_");
		
		File dest = new File(System.getProperty("user.dir")+"\\ScreenShot\\"+ timestamp +".jpg");
		FileHandler.copy(source, dest);	
	}
	public static String readPropertyFile(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"\\propFlile.properties");
		prop.load(propFile);
		String value = prop.getProperty(key);
		return value;
	}
	public static void log ()   //Log4j
	{
		
	}
}
