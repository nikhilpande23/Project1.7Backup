package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsPOM {
	
	public WebDriver driver;
	
	
	public ContactUsPOM ( WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements( driver , this);
	}
	
	
	
	
	public void verifyContactUspageTitle() {
		
		Assert.assertEquals(driver.getTitle(), "Contact Us");
		
	}
	
	
	@FindBy (xpath = "//h1[normalize-space()='Contact Us']")
	public WebElement HeadingConactUspage ;
	
	public void verifyHeadingConactUspage() {
		
		Assert.assertTrue(HeadingConactUspage.isDisplayed());
	}
	
//	-------------------------------------------------------------------------
	
	@FindBy (xpath = "//input[@id='input-name']")
	public WebElement yourNameField;
	
	public void verifyYourNameField() {
		
		Assert.assertTrue(yourNameField.isDisplayed());
	}
	
	public void verifyPreEnteredTextOfYournameField(String name) throws InterruptedException {
		Assert.assertEquals(yourNameField.getText(), name);
	}
	
	public void enteryourNameField(String yourName) {
		
		yourNameField.sendKeys(yourName);
	}
	
//	--------------------------------------------------------------------
	
	@FindBy (xpath = "//input[@id='input-email']")
	public WebElement emailAddressField ;
	
	public void verifyemailAddressField() {
		Assert.assertTrue(emailAddressField.isDisplayed());
	}
	
	public void verifyPreEnteredTextOfEmailField(String email) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(emailAddressField.getText(), email);
	}
	
	public void enteremailAddressField(String email) {
		
		emailAddressField.sendKeys(email);
	}
	
//	---------------------------------------------------------------------------
	
	@FindBy (xpath = "//textarea[@id='input-enquiry']")
	public WebElement enquiryField;
	
	public void verifyenquiryField() {
		Assert.assertTrue(enquiryField.isDisplayed());
	}
	
	public void enterInEnquiryField(String enquiryDescription) {
		enquiryField.sendKeys(enquiryDescription);
	}
	
//	------------------------------------------------------------------------
	
	
	@FindBy (xpath = "//input[@value='Submit']")
	public WebElement submitButton;
	
	public void verifysubmitButton() {
		Assert.assertTrue(submitButton.isEnabled());
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	
	
	public void verifySuccessfulenquireySentMessage() {
		
		Assert.assertTrue(false, "Enquiry send successfully message should be displayed...");
		
	}
	
	
//	----------------- verify warning msg of each field of contact us page---------------------------
	
	
	@FindBy (xpath = "//div[contains(text(),'Name must be between 3 and 32 characters!')]")
	public WebElement yourNameWarning;
	
	@FindBy (xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	public WebElement emailWarning;
	
	@FindBy (xpath = "//div[contains(text(),'Enquiry must be between 10 and 3000 characters!')]")
	public WebElement enquiryWarning;
	
	public void verifyFieldWarningMessages() {
		
		Assert.assertEquals(yourNameWarning.getText(), "Name must be between 3 and 32 characters!");
		
		Assert.assertEquals(emailWarning.getText(), "E-Mail Address does not appear to be valid!");
		
		Assert.assertEquals(enquiryWarning.getText(), "Enquiry must be between 10 and 3000 characters!");
	}
	
	
//	----------------------------------------------------------------------------------------------------------
	
	
	@FindBy (xpath = "//a[normalize-space()='Continue']")
	public WebElement continueButtonContactuspage;
	
	public boolean isEnquirySent() {
		return continueButtonContactuspage.isDisplayed();
	}
	
//	---------------------------------
	
	@FindBy (xpath = "//div[@class='collapse navbar-collapse navbar-ex1-collapse']")
	public WebElement breadcrumb;
	
	public boolean verifyBreadcrumbContactuspage() {
		return breadcrumb.isDisplayed();
	}
	
	
}
