package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AccountCreateSuccessPOM {
	
	public WebDriver driver;
	
	
	
	public AccountCreateSuccessPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//h1[.='Your Account Has Been Created!']")
	 public WebElement accCreatedMessage;
	
	public void verifyAcCreatedSuccessfully() {
		
		 
		 Assert.assertEquals(driver.getTitle() , "Your Account Has Been Created!");
		
	}

}
