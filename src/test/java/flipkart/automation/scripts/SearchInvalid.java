package flipkart.automation.scripts;
import flipkart.automation.pageobjects.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import flipkart.automation.genericlib.*;

public class SearchInvalid extends BaseClass{
	@Test
	public void test3() throws FileNotFoundException, IOException, InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent4.html");
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("true","SearchInvalid");
		Login l2 = new Login(driver);
		SearchProduct sp = new SearchProduct(driver);
		Photo pie = new Photo();
	String emailadd = p.getPropertiesFileData("email");
	String pass = p.getPropertiesFileData("password");
	Thread.sleep(3000);
	test.log(Status.INFO, "Starting test case");
	l2.getemailtb().sendKeys(emailadd);
	l2.getpasswordtb().sendKeys(pass);
	test.pass("Entered text successfully");
	l2.signInbtn();
	test.pass("Clicked on Signin Button");
	Thread.sleep(5000);
	sp.getSearchtb("zxcvzczxcvz");
	test.pass("Entered the product");
	Thread.sleep(2000);
	pie.getPhoto(driver, "result");
	
	driver.close();
	test.pass("Closed the browser");
	test.info("Test Completed");
	extent.flush();
}
}

