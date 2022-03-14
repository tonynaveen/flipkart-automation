package flipkart.automation.scripts;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import flipkart.automation.genericlib.*;
import flipkart.automation.pageobjects.*;
public class Signout extends BaseClass{
	@Test
	public void test_logout() throws FileNotFoundException, IOException, InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent3.html");
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("true","SearchInvalid");
		Login l = new Login(driver);
		Photo p2 = new Photo();
		Logout lout = new Logout(driver);
		String emailadd = p.getPropertiesFileData("email");
		String pass = p.getPropertiesFileData("password");
		test.log(Status.INFO,"Test Started successfully");
		l.getemailtb().sendKeys(emailadd);
		l.getpasswordtb().sendKeys(pass);
		l.signInbtn();
		test.pass("Logged in succesfully ");
		Thread.sleep(4000);
		WebElement lp = lout.logout();
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(lp).perform();
		Thread.sleep(2000);
		test.pass("moved to element");
		p2.getPhoto(driver, "Click on log out");
		lout.llout().click();
		test.pass("logged out succesfully");
		Thread.sleep(3000);
		p2.getPhoto(driver, "loggedout");
		driver.close();
		extent.flush();
	}

}
