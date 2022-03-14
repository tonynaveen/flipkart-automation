package flipkart.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	@FindBy(xpath="//div[contains(text(),'Naveen')]")
	private WebElement logout;
	
	@FindBy(xpath="//div[normalize-space()='Logout']")
	private WebElement llout;
	
	public Logout(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement llout() {
		return llout;
	}
	public WebElement logout() {
		return logout;
	}
	
	
}
