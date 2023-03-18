package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginpagePOM {

public WebDriver driver;
	
	public LoginpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "input-email")
	public WebElement emailField;
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	@FindBy (id = "input-password")
	public WebElement passwordField;
	
	public void enterPassword(String email) {
		passwordField.sendKeys(email);
	}
	
	@FindBy (xpath = "//input[@type='submit']")
	public WebElement loginButton;
	
	public void clickLoginbutton() {
		loginButton.click();
	}
	
	@FindBy (xpath = "(//a[.='Forgotten Password'])[1]")
	public WebElement forgotPasswordlink ;
		
	public void isForgotPassLinkPresent() {
		Assert.assertTrue(forgotPasswordlink.isDisplayed());
	}
	public void clickForgotPassLink() {
		forgotPasswordlink.click();
	}
	
	
	public void verifyEmailFieldPlaceholder() {
		
		Assert.assertEquals("E-Mail Address", emailField.getAttribute("placeholder") );
	}
	
	public void verifyPasswFieldPlaceholder() {
		Assert.assertEquals("Password", passwordField.getAttribute("placeholder") );
	}
	
	public void verifyLoginPage() {
		
		Assert.assertEquals( driver.getTitle(), "Account Login") ;
		
	}
}
