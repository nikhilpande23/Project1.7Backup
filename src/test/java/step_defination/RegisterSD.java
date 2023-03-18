package step_defination;
import java.io.IOException;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pom.AccountCreateSuccessPOM;
import pom.LoginpagePOM;
import pom.PhonesModulePOM;
import pom.RegistrationPagePOM;
import utilities.Baseclass;

public class RegisterSD extends Baseclass {
	
//	----------------------- Hooks Start------------------------------
	
//	----------------------- Hooks End---------------------------------
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() throws IOException, InterruptedException {
		
		driver.get(getFromPropertyFile("url"));
		
		
		
		Thread.sleep(1000);
//		homepage.clickMyaccdrop();
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();
		
		
		Thread.sleep(1000);
//		homepage.clickRegisterOption();
		driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();
		
		registeraccpage = new RegistrationPagePOM(driver);
		accSuccesspage = new AccountCreateSuccessPOM(driver);
	}
	
	
	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		registeraccpage.enterfirstNameField(datamap.get("firstName"));
		registeraccpage.enterlastNameField(datamap.get("lastName"));
		registeraccpage.entertelephoneField(datamap.get("telephone"));
		registeraccpage.enterPassword(datamap.get("password"));
		registeraccpage.enterConfirmPassword(datamap.get("password"));
		
	}
	
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registeraccpage.acceptPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registeraccpage.clickContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		accSuccesspage.verifyAcCreatedSuccessfully();
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registeraccpage.ClickYesNewsletter();
	}

	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		registeraccpage.enterfirstNameField(datamap.get("firstName"));
		registeraccpage.enterlastNameField(datamap.get("lastName"));
		registeraccpage.enterEmailField(datamap.get("email"));
		registeraccpage.entertelephoneField(datamap.get("telephone"));
		registeraccpage.enterPassword(datamap.get("password"));
		registeraccpage.enterConfirmPassword(datamap.get("password"));
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		registeraccpage.verifyWarningMessageDuplicateEmail();
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		registeraccpage.enterfirstNameField("");
		registeraccpage.enterlastNameField("");
		registeraccpage.enterEmailField("");
		registeraccpage.entertelephoneField("");
		registeraccpage.enterPassword("");
		registeraccpage.enterConfirmPassword("");
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
		registeraccpage.verifyFnameWarnMsg();
		registeraccpage.verifyLnameWarn();
		registeraccpage.verifyEmailWarn();
		registeraccpage.verifyTelephoneWarn();
		registeraccpage.verifyPasswordWarn();
	}
	
//	--------------------------------- NewLY ADDED --------------------------------------------
	
	@When("User enters the details into below fields for invalid email")
	public void user_enters_the_details_into_below_fields_for_invalid_email(DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class , String.class);
		registeraccpage.enterfirstNameField(datamap.get("firstName"));
		registeraccpage.enterlastNameField(datamap.get("lastName"));
		registeraccpage.entertelephoneField(datamap.get("telephone"));
		registeraccpage.enterPassword(datamap.get("password"));
		registeraccpage.enterConfirmPassword(datamap.get("password"));
			
	}
	
	@When("user enters invalid email as {string} in email field")
	public void user_enters_invalid_email_as_in_email_field(String email) {
		registeraccpage.enterEmailField(email);
	}
	
	
	@Then("User should not get Successfully create account page")
	public void user_should_not_get_Successfully_create_account_page() {
		
		registeraccpage.verifyPageTitleRegisterAccPage();
	}
	
	@Then("user should get proper placeholders for all the text fileds")
	public void user_should_get_proper_placeholders_for_all_the_text_fileds() {
		registeraccpage.verifyPlaceholders();
	}
	
//	1
//	@Then("should get all the mandatory fileds along with * symbol")
//	public void should_get_all_the_mandatory_fileds_along_with_symbol() {
//		
//	}
	
	
	@Then("user should not get Account success page, instead of should get warning message about Password complexcity standards")
	public void user_should_not_get_account_success_page_instead_of_should_get_warning_message_about_password_complexcity_standards() {
		
		Assert.assertEquals( registeraccpage.driver.getTitle() , "Register Account"  );
	}
	
	
	@Then("user should get unselected Privacy Policy Checkbox by default")
	public void user_should_get_unselected_privacy_policy_checkbox_by_default() {
		Assert.assertFalse(registeraccpage.verifyPrivacyPolicyCheckBox(), "is method returns TRUE means check box is by default selected, means BUG");
	}
	
	@When("User enters the details into below fields for invalid phone number")
	public void user_enters_the_details_into_below_fields_for_invalid_phone_number(DataTable dataTable) {
	Map<String, String> datamap = dataTable.asMap(String.class, String.class);
	registeraccpage.enterfirstNameField(datamap.get("firstName"));
	registeraccpage.enterlastNameField(datamap.get("lastName"));	
	registeraccpage.enterPassword(datamap.get("password"));
	registeraccpage.enterConfirmPassword(datamap.get("password"));
		
	}
	
	
	@When("user enters invalid phone as {string} in phone field")
	public void user_enters_invalid_phone_as_in_phone_field(String phone) {
		registeraccpage.entertelephoneField(phone);
	}


	@Then("User account should not be created")
	public void user_account_should_not_be_created() {
		
		Assert.assertEquals( registeraccpage.driver.getTitle() , "Register Account"  );
	}
	
	
	
	@When ("User enters the space into all fields")
	public void User_enters_the_space_into_all_fields() {
		registeraccpage.enterfirstNameField(" ");
		registeraccpage.enterlastNameField(" ");
		registeraccpage.entertelephoneField(" ");
		registeraccpage.enterPassword(" ");
		registeraccpage.enterConfirmPassword(" ");
	}
	

	@Then("user should get by defaulted selected Newsletter checkbox")
	public void user_should_get_by_defaulted_selected_newsletter_checkbox() {
	    
	   Assert.assertTrue(registeraccpage.Verifynewsletter() , "Newsletter checkbox should Selected by default");
	}
	
	@Then("User should get a proper warning message related to privacy policy")
	public void user_should_get_a_proper_warning_message_related_to_privacy_policy() {
	    
	   registeraccpage.verifyPrivacyPolicyWarnMsg();
	}
	
	@When("user clicks on Login link")
	public void user_clicks_on_login_link() {
	    
	   registeraccpage.clickLoginLink();
	}
	
	
	@Then("user should navigates to the Login page")
	public void user_should_navigates_to_the_login_page() {
		
		loginpage = new LoginpagePOM(driver);
	   loginpage.verifyLoginPage() ;
	}
	
	
	@When("user clicks on Phones module")
	public void user_clicks_on_phones_module() {
	    registeraccpage.clickPhoneModule();
	}
	
	
	@Then("user should navigates to Phones page")
	public void user_should_navigates_to_phones_page() {
	    
		phonespage = new PhonesModulePOM(driver);
		phonespage.verifyPhonesPage();
	}
	
	@Then("User should get proper warning message about confirm password field")
	public void user_should_get_proper_warning_message_about_confirm_password_field() {
	    registeraccpage.verifyconfirmPassWarnmsg();
	   
	}
	
	@When ("user enters new valid email into the email field")
	public void user_enters_new_valid_email_into_the_email_field() {
		registeraccpage.enterEmailField("  " +randomEmail()+"  ");
	}
	
	@When("user do not enters password into confirm password field")
	public void user_do_not_enters_password_into_confirm_password_field() {
		
		registeraccpage.enterConfirmPassword("");
	}
	
	@When("User enters the details into below fields except confirm password filed")
	public void user_enters_the_details_into_below_fields_except_confirm_password_filed(DataTable dataTable) {
		
		Map<String, String> datamap = dataTable.asMap(String.class , String.class) ;
		
		registeraccpage.enterfirstNameField(datamap.get("firstName"));
		registeraccpage.enterConfirmPassword(datamap.get("lastName"));
		registeraccpage.entertelephoneField(datamap.get("telephone"));
		registeraccpage.enterPassword(datamap.get("password"));
		
	
	}
	
	
	
	
}
