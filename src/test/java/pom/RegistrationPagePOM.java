package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPagePOM {
	
	public WebDriver driver;
	
	public RegistrationPagePOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	
	@FindBy (id = "input-firstname")
	public WebElement firstNameField;
	
	public void enterfirstNameField(String firstname) {
		firstNameField.sendKeys(firstname);
	}
	
	
	@FindBy (id = "input-lastname")
	public WebElement lastNameField;
	
	public void enterlastNameField(String lastname) {
		lastNameField.sendKeys(lastname);
	}
	
	
	@FindBy (id = "input-email")
	public WebElement emailField;
	
	public void enterEmailField(String email) {
		emailField.sendKeys(email);
	}
	
	
	@FindBy (id = "input-telephone")
	public WebElement telephoneField;
	
	public void entertelephoneField(String phone) {
		telephoneField.sendKeys(phone);
	}
	
	
	@FindBy (id = "input-password")
	public WebElement passwordField;
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	
	@FindBy (id = "input-confirm")
	public WebElement confirmpasswordField;
	
	public void enterConfirmPassword(String cnfpassword) {
		confirmpasswordField.sendKeys(cnfpassword);
	}
	
	
	@FindBy (xpath = "(//input[@type='radio'])[2]")
	public WebElement newsletterSubscribeYes;
	
	public void ClickYesNewsletter() {
		newsletterSubscribeYes.click();
	}
	
	
	@FindBy (xpath = "(//input[@type='radio'])[3]")
	public WebElement newsletterSubscribeNo;
	
	public void ClickNoNewsletter() {
		newsletterSubscribeNo.click();
	}
	
	
	@FindBy (xpath = "//input[@type='checkbox']")
	public WebElement privacyPolicy;
	
	public void acceptPrivacyPolicy() {
		if (privacyPolicy.isSelected()==true) {
			
		}
		
		else if (privacyPolicy.isSelected()==false) {
			privacyPolicy.click();
		}
	}
	
	
	@FindBy (xpath = "//input[@type='submit']")
	public WebElement continueButton;
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
//	----------------------------- Textbox Warning messages ----------------------------------------------------
	
	
	@FindBy (xpath = "//div[.=' Warning: E-Mail Address is already registered!']")
	public WebElement warningMessageDuplicateEmail;
	
	public void verifyWarningMessageDuplicateEmail() {
		Assert.assertEquals("Warning: E-Mail Address is already registered!", warningMessageDuplicateEmail.getText() );
	}
	
	
	
	@FindBy (xpath = "//div[.='First Name must be between 1 and 32 characters!']")
	public WebElement fnameWarn;
	
	public void verifyFnameWarnMsg() {
		Assert.assertEquals("First Name must be between 1 and 32 characters!", fnameWarn.getText() );
	}
	
	
	@FindBy (xpath = "//div[.='Last Name must be between 1 and 32 characters!']")
	public WebElement lnameWarn;
	
	public void verifyLnameWarn() {
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", lnameWarn.getText() );
	}
	
	
	@FindBy (xpath = "//div[.='E-Mail Address does not appear to be valid!']")
	public WebElement emailWarn;
	
	public void verifyEmailWarn() {
		Assert.assertEquals("E-Mail Address does not appear to be valid!", emailWarn.getText() );
	}
	
	
	@FindBy (xpath = "//div[.='Telephone must be between 3 and 32 characters!']")
	public WebElement telephoneWarn;
	
	public void verifyTelephoneWarn() {
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", telephoneWarn.getText() );
	}
	
	
	@FindBy (xpath = "//div[.='Password must be between 4 and 20 characters!']")
	public WebElement passwordWarn;
	
	public void verifyPasswordWarn() {
		Assert.assertEquals("Password must be between 4 and 20 characters!", passwordWarn.getText() );
		
	}
	
	
	public void verifyPlaceholders() {
		
		Assert.assertEquals("First Name", firstNameField.getAttribute("placeholder") );
		Assert.assertEquals("Last Name", lastNameField.getAttribute("placeholder") );
		Assert.assertEquals("E-Mail", emailField.getAttribute("placeholder"));
		Assert.assertEquals("Telephone", telephoneField.getAttribute("placeholder"));
		Assert.assertEquals("Password", passwordField.getAttribute("placeholder"));
		Assert.assertEquals("Password Confirm", confirmpasswordField.getAttribute("placeholder"));

	}
	
	
	public boolean verifyPrivacyPolicyCheckBox() {
		return privacyPolicy.isSelected();
	}
	
	public boolean Verifynewsletter() {
		return newsletterSubscribeYes.isSelected();
	}
	
	
	
	@FindBy (xpath = "//div[@class='alert alert-danger alert-dismissible']")
	public WebElement privacyWarnMsg;
	
	public void verifyPrivacyPolicyWarnMsg() {
		Assert.assertEquals( privacyWarnMsg.getText() , "Warning: You must agree to the Privacy Policy!" );
	}
	
	
	@FindBy (xpath = "(//a[.='Login'])[2]")
	public WebElement loginLink;
	
	public void clickLoginLink() {
		loginLink.click();
	}
		
	
	@FindBy (xpath = "//a[.='Phones & PDAs']")
	public WebElement phoneModule;
	
	public void clickPhoneModule() {
		phoneModule.click();
	}
	
	@FindBy (xpath = "//div[.='Password confirmation does not match password!'][@class='text-danger']")
	public WebElement confirmPassWarnmsg;
	
	public void verifyconfirmPassWarnmsg() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertEquals(confirmPassWarnmsg.getText(), "Password confirmation does not match password!");
	}
	
	public void verifyPageTitleRegisterAccPage() {
		Assert.assertEquals("Register Account", driver.getTitle());
	}
	

}
