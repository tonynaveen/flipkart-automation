package flipkart.automation.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ViewCart {
	
	@FindBy(xpath="//a[contains(.,'view cart')][1]")
	private WebElement viewcrt;
	
	public ViewCart(WebDriver driver){
		PageFactory.initElements(driver,this);
		
	}
	public WebElement viewthecart() {
		return viewcrt;
	}
}

