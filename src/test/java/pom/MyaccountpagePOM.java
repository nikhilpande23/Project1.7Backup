package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyaccountpagePOM {
	
	public WebDriver driver;
	
	public MyaccountpagePOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy (xpath = "//a[.='Edit your account information']")
	public WebElement EdityouraccountinformationMenu;
	
	public boolean displayStatusEditAccMenu() {
		return EdityouraccountinformationMenu.isDisplayed();
	}
	
	
	@FindBy (xpath = "(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
	public WebElement MyaccountMenu;
	
	public void clickMyaccountMenu() {
		MyaccountMenu.click();
	}
	
	
	@FindBy (xpath = "(//a[.='Logout'])[1]")
	public WebElement logoutOption;
	
	public void clicklogoutOption() {
		logoutOption.click();
	}
	
	public void isLoginedInAgain() {
		Assert.assertFalse(EdityouraccountinformationMenu.isDisplayed(), "Still logged-in after : Loggingout from the Application and browsing back");
	}
	
	
//	----------moved from homepage to here ...bcoz after login, user get My acc  page..not homepage so...
	
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
	
	
	@FindBy (xpath = "//p[.='There is no product that matches the search criteria.']")
	public WebElement noProductWarning ;
		
	public void verifyNoProductWarning() {
		Assert.assertEquals( noProductWarning.getText() ,"There is no product that matches the search criteria." );
	}

}
