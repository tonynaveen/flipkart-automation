package flipkart.automation.scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import flipkart.automation.genericlib.BaseClass;
import flipkart.automation.genericlib.Photo;
import flipkart.automation.pageobjects.*;


public class SignIn extends BaseClass{
	//Report Initialization

	@Test(priority=0)
	public void test1() throws FileNotFoundException, IOException, InterruptedException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent1.html");
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("true","Signin");
		Login l=new Login(driver);
		Photo pie = new Photo();
		String emailadd = p.getPropertiesFileData("email");
		String pass = p.getPropertiesFileData("password");
		test1.log(Status.INFO,"Starting test case");
		l.getemailtb().sendKeys(emailadd);
		l.getpasswordtb().sendKeys(pass);
		test1.pass("Entered data successfully");
		l.signInbtn();
		Thread.sleep(3000);
		pie.getPhoto(driver, "signed-in");
		
		SearchProduct s=new SearchProduct(driver);
		s.getSearchtb("refrigerator");
		Thread.sleep(3000);
		test1.pass("Entered product name successfully");
		pie.getPhoto(driver, "product name");
		FilterAndSort f=new FilterAndSort(driver);
		f.getSamsung().click();
		Thread.sleep(1000);
		f.getFlipkartAssured().click();
		Thread.sleep(1000);
		f.getExpandColor().click();
		Thread.sleep(1000);
		f.getSilverColor().click();
		Thread.sleep(1000);
		f.getExpandCapacity().click();;
		Thread.sleep(1000);
		f.get251To300L().click();;
		Thread.sleep(1000);
		u.dropDown(f.getMinPrice(),"₹25000");
		Thread.sleep(1000);
		u.dropDown(f.getMaxPrice(),"₹30000");
		Thread.sleep(1000);
		f.getSortL2H().click();
		Thread.sleep(1000);
		f.getRating().click();
		Thread.sleep(2000);
		test1.pass("All the filters are successfully applied");
		pie.getPhoto(driver, "filters");
		PrintProducts p1=new PrintProducts(driver);
		List<WebElement> productlist=p1.getProducts();
		System.out.println(productlist.size());
		test1.pass("Successfully printed in the console");
		ArrayList<String> a=new ArrayList<String>();

		for(WebElement product:productlist) {
			int x=product.getLocation().getX();
			int y=product.getLocation().getY();
			System.out.println(x+" "+y);
			try {
				u.scrollTo(driver, x, y);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			a.add(product.getText());
		}

		u.scrollTo(driver,0,0);
		pie.getPhoto(driver, "get-list");
		Collections.sort(a);

		for(Object temp:a) {
			Reporter.log(temp.toString(),true);
			System.out.println();
		}
		
		ProductDetails p2=new ProductDetails(driver);
		int x=p2.get2ndProduct().getLocation().getX();
		int y=p2.get2ndProduct().getLocation().getY();
		u.scrollTo(driver, x, y);
		
		Thread.sleep(2000);
		
		p2.get2ndProduct().click();
		Thread.sleep(1000);
		ArrayList<String> child= new ArrayList<String>(u.childParentBrowserPopup(driver));
		driver.switchTo().window(child.get(1));
		Thread.sleep(3000);
		
		ShareProduct s1=new ShareProduct(driver);
		s1.getShareBtn().click();
		Thread.sleep(1000);
		s1.getFacebook().click();
		Thread.sleep(2000);
		test1.pass("Sharing the product started");
		ArrayList<String> child1= new ArrayList<String>(u.childParentBrowserPopup(driver));
		System.out.println(child1.size());
		driver.switchTo().window(child1.get(2));
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		pie.getPhoto(driver, "facebook-pop-up");
		s1.getFacebookEmail().sendKeys(p.getPropertiesFileData("facebookemail"));
		s1.getFacebookPass().sendKeys(p.getPropertiesFileData("facebookpassword"));
		s1.facebooklogin().click();
		test1.pass("Entered facebook email and password successfully");
		Thread.sleep(6000);
		pie.getPhoto(driver, "posted story");
		s1.postToFacebook().click();
		test1.pass("Successfully the user posted to facebook");
		Thread.sleep(2000);
		driver.switchTo().window(child1.get(1));
		driver.navigate().refresh();
		Thread.sleep(3000);
		AddToCart a1=new AddToCart(driver);
		Thread.sleep(2000);
		a1.addToCart().click();
		Thread.sleep(1000);
		pie.getPhoto(driver, "cart");
		test1.pass("The product is added to the cart");
		Thread.sleep(5000);
		test1.log(Status.INFO,"Test completed");
		extent.flush();
	}
	
}
























