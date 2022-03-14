package flipkart.automation.genericlib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements AutoConstants{
	public WebDriver driver;
	public PropertiesFileData p;
	public Photo p1;
	public Utilities u=new Utilities();
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		p=new PropertiesFileData();
		driver.get(p.getPropertiesFileData("url"));
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	/**
	 * to close all windows and taking screenshot of failed testcases
	 * @param r
	 * @throws IOException
	 */
	@AfterMethod
	public void closeApp() throws IOException {
		
		driver.quit();
	}

}









