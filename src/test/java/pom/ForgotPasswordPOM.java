package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPasswordPOM {
	
	public WebDriver driver;
	
	public ForgotPasswordPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//p[.='Enter the e-mail address associated with your account. Click submit to have a password reset link e-mailed to you.']")
	public WebElement forgotpasstext;
	
	public void verifyForgotPassPage() {
		Assert.assertEquals("Enter the e-mail address associated with your account. Click submit to have a password reset link e-mailed to you.", forgotpasstext.getText() );
	}

}
