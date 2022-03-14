package flipkart.automation.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import flipkart.automation.genericlib.BaseClass;
import flipkart.automation.genericlib.Photo;
import flipkart.automation.pageobjects.Login;

public class verifyinglogin extends BaseClass{
@SuppressWarnings("resource")
@Test
	public void test2() throws InterruptedException, IOException {
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent2.html");
	ExtentReports extent1 = new ExtentReports(); 
	extent1.attachReporter(htmlReporter);
	ExtentTest test2 = extent1.createTest("true","verifyinglogin");
	Login l=new Login(driver);
	Photo pit = new Photo();
	

		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFCell cell;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		// Import excel sheet. 

		File src=new File("/home/naveen/eclipse-workspace/flipkart.automation/src/test/java/flipkart/automation/testdata/Book 4.xlsx"); 
		test2.log(Status.INFO,"Test Started ");
		// Load the file. 

		FileInputStream finput = new FileInputStream(src); 
		test2.pass("Added excel file to the test");
		// Load the workbook. 

		workbook = new XSSFWorkbook(finput); 

		// Load the sheet in which data is stored. 

		sheet= workbook.getSheetAt(0); 
		test2.pass("Retrieved the sheet no");

		//for(int i=1; i<=sheet.getLastRowNum(); i++) { 

		// Import data for Email. 

		cell = sheet.getRow(1).getCell(1); 

		cell.setCellType(CellType.STRING); 
		Thread.sleep(2000);
		//driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue()); 
		l.getemailtb().sendKeys(cell.getStringCellValue());
		// Import data for password. 
		test2.pass("Sending email values from excel field to email filed successfully");
		cell = sheet.getRow(1).getCell(2); 

		cell.setCellType(CellType.STRING); 
		Thread.sleep(3000);
		//driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue()); 
		l.getpasswordtb().sendKeys(cell.getStringCellValue());
		test2.pass("Sending passwords from excel field to password field successfully");
		//driver.findElement(By.name("login")).click();
		l.signInbtn();
		Thread.sleep(1000);
		test2.pass("Retrieved data values from excel successfully ");
		pit.getPhoto(driver, "verifiedtrue");
		test2.pass("Snapshot was taken successfully");
		driver.close();
		test2.pass("Browser closed succesfully");
		test2.log(Status.INFO,"Test Completed");
		extent1.flush();	
	}
}
