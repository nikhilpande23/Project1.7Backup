package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomepagePOM {
	
	public WebDriver driver;
	
	public HomepagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy (xpath = "(//a[@class='dropdown-toggle'])[1]")
	public WebElement myaccdrop;
	
	public void clickMyaccdrop() {
		myaccdrop.click();
	}
	
	@FindBy (xpath = "//a[.='Login']" )
	public WebElement loginOption;
	
	public void loginOption() {
		loginOption.click();
	}
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement warningmessage;
	
	public boolean checkWarningMessage() {
		return warningmessage.isDisplayed();
	}
	
	@FindBy (xpath = "(//a[normalize-space()='Register'])[1]")
	public WebElement registerOption;
	
	public void clickRegisterOption() {
		registerOption.click();
	}
	
	
	@FindBy (xpath = "//input[@type='text']")
	public WebElement searchTextField;
	
	public void enterTextInSearchField(String productname) {
		searchTextField.sendKeys(productname);
	}
	
	
	@FindBy (xpath = "(//button[@type='button'])[4]")
	public WebElement searchButton;
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	
	public void verifyPlaceHolderSearchField() {
		Assert.assertEquals( searchTextField.getAttribute("placeholder"), "Search" );
	}
	
	
	
	@FindBy (xpath = "//i[@class='fa fa-phone']")
	public WebElement conactusICONheader;
	
	public void clickConactusICONheader() {
		conactusICONheader.click();
	}
	
	
	@FindBy (xpath = "//a[text()='Contact Us']")
	public WebElement conactusLinkfooter;
	
	public void clickConactusLINKfooter() {
		conactusLinkfooter.click();
	}
	
}
