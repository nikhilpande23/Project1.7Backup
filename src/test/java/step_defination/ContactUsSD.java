package step_defination;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pom.ContactUsPOM;
import pom.HomepagePOM;
import pom.LoginpagePOM;
import utilities.Baseclass;


public class ContactUsSD extends Baseclass {
	
	
	
	@When("user Clicks on Phone icon option from the header options")
	public void user_clicks_on_phone_icon_option_from_the_header_options() {
		homepage = new HomepagePOM(driver);
	    homepage.clickConactusICONheader();
	    
	}

	@Then("user should navigates to Contact Us page")
	public void user_should_navigates_to_contact_us_page() {
		
		contactuspage = new ContactUsPOM(driver);
		contactuspage.verifyContactUspageTitle();
	}

	@When("user clicks on Contact us link from Footer options")
	public void user_clicks_on_contact_us_link_from_footer_options() {
	    
		homepage = new HomepagePOM(driver);
		homepage.clickConactusLINKfooter();
	}

	@Then("user should get required details and fields are proper displayed in the Contact Us page")
	public void user_should_get_required_details_and_fields_are_proper_displayed_in_the_contact_us_page() {
	    
		contactuspage.verifyHeadingConactUspage();
		contactuspage.verifyYourNameField();
		contactuspage.verifyemailAddressField();
		contactuspage.verifyenquiryField();
		contactuspage.verifysubmitButton();
	    
	}

	@Then("user should get all the text fields of contact us page are mandetory")
	public void user_should_get_all_the_text_fields_of_contact_us_page_are_mandetory() {
	    
		contactuspage.verifyHeadingConactUspage();
		contactuspage.verifyYourNameField();
		contactuspage.verifyemailAddressField();
		contactuspage.verifyenquiryField();
		contactuspage.verifysubmitButton();
	    
	}

	@Then("user should get all the fields are Blank by default")
	public void user_should_get_all_the_fields_are_blank_by_default() throws InterruptedException {
	    
		contactuspage.verifyPreEnteredTextOfYournameField("");
		contactuspage.verifyPreEnteredTextOfEmailField("");
		contactuspage.enterInEnquiryField("");
		
	    
	}

	@When("user enters valid description in related field")
	public void user_enters_valid_description_in_related_field() {
		
	    
	    contactuspage.enteryourNameField("XYZ");
	    contactuspage.enteremailAddressField("validemail@gmail.com");
	    contactuspage.enterInEnquiryField("savj gsc CKW");
	}

	

	@Then("user should navigates to login page")
	public void user_should_navigates_to_login_page() {
	    
		loginpage = new LoginpagePOM(driver);
		
		loginpage.verifyLoginPage();
	    
	}


	@Then("user should get successful enquirey sent message")
	public void user_should_get_successful_enquirey_sent_message() {
	    
	    contactuspage.verifySuccessfulenquireySentMessage(); // making false.. bcoz no msg seen manually
	}

	@Then("user dont enter anything in all the fields")
	public void user_dont_enter_anything_in_all_the_fields() {
	    
		contactuspage = new ContactUsPOM(driver);
		
		contactuspage.enteryourNameField("");
		contactuspage.enteremailAddressField("");
		contactuspage.enterInEnquiryField("");
	    
	}

	@Then("clicks on submit button of contact us page")
	public void clicks_on_submit_button_of_contact_us_page() {
	    
		contactuspage.clickSubmitButton();
	    
	}

	@Then("user should get warning messages for all the fields")
	public void user_should_get_warning_messages_for_all_the_fields() {
	    
	    contactuspage.verifyFieldWarningMessages();
	}

	@When("user enters invalid email along with other details")
	public void user_enters_invalid_email_along_with_other_details() {
	    
	    contactuspage.enteremailAddressField(randomEmail());
	    contactuspage.enteryourNameField("Salman");
	    contactuspage.enterInEnquiryField("sgahc gSVQ gkcq GK");
	}

	@Then("request should not send instead of Confirm with OTP notification should come")
	public void request_should_not_send_instead_of_confirm_with_otp_notification_should_come() {
	    
	    Assert.assertFalse(contactuspage.isEnquirySent(), "enquiry should be sent but only with valid info");
	}

	@Then("user should get proper breadcrum for page")
	public void user_should_get_proper_breadcrum_for_page() {
	    
	    Assert.assertTrue(contactuspage.verifyBreadcrumbContactuspage());
	}

	@Then("user should get proper page title, Page Heading and Page Title of contact us page")
	public void user_should_get_proper_page_title_page_heading_and_page_title_of_contact_us_page() {
	    
	    contactuspage.verifyContactUspageTitle();
	    contactuspage.verifyHeadingConactUspage();
	}
	
	
	// unable to get pre-entered text
	
//		@Then("user should get name as {string} and email fields {string} are by default entered with a valid name and email")
//		public void user_should_get_name_as_and_email_fields_are_by_default_entered_with_a_valid_name_and_email(String name, String email) throws InterruptedException {
//			
//			contactuspage = new ContactUsPOM(driver);
//		    contactuspage.verifyPreEnteredTextOfYournameField(name);
//		    contactuspage.verifyPreEnteredTextOfEmailField(email);
	//	
//		}

}
