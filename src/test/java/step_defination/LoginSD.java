package step_defination;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.ForgotPasswordPOM;
import pom.HomepagePOM;
import pom.LoginpagePOM;
import pom.MyaccountpagePOM;
import utilities.Baseclass;



public class LoginSD extends Baseclass {
	
	
	
//	----------------------- Hooks Start----------------------------------
	
	@Before
	public void driverSetup() throws IOException {
		String browser = getFromPropertyFile("browser");
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver=WebDriverManager.chromedriver().create();
			break;
		case "firefox":
			driver=WebDriverManager.firefoxdriver().create();
			break;
		default:driver=null;
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
	}
	
	@After
	public void teardown(Scenario sc) {
		
		String ssname=sc.getName().replaceAll(" ","_");
		
		if (sc.isFailed()) {
			TakesScreenshot ss = (TakesScreenshot) driver;
			byte[] file = ss.getScreenshotAs(OutputType.BYTES);
			sc.attach(file, "image/png", ssname);
		}
		driver.quit();
	}
	
//	----------------------- Hooks End----------------------------------
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws IOException {
		
		driver.get(getFromPropertyFile("url"));
		homepage = new HomepagePOM(driver);
		homepage.clickMyaccdrop();
		homepage.loginOption();
		loginpage = new LoginpagePOM(driver);
		myaccpage = new MyaccountpagePOM(driver);
	}

	@When("^User enters valid email address (.*) into email field by DDT$") //only for DDT
	public void user_enters_valid_email_address_into_email_field_by_DDT(String validEmail) {
		loginpage.enterEmail(validEmail);
	}

	@When("^User enters valid password (.*) into password field by DDT$") //only for DDT
	public void user_enters_valid_password_into_password_field_by_DDT(String validpassw) {
		loginpage.enterPassword(validpassw);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		
		loginpage.clickLoginbutton();
		
		Thread.sleep(2000);
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		loginpage = new LoginpagePOM(driver);
		boolean isPresent = myaccpage.displayStatusEditAccMenu();
		if (isPresent==true) {
			Assert.assertTrue(isPresent);
		}
		else if (isPresent==false) {
			Assert.assertTrue(isPresent, "This is invalid Login");
		}		
	}


	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		loginpage.enterEmail(randomEmail());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpassw) {
		loginpage.enterPassword(invalidpassw);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		boolean warning = homepage.checkWarningMessage();
		if (warning==true) {
			Assert.assertTrue(warning);
		}
		else if (warning==false) {
			Assert.assertTrue(warning);
		}
	}


	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		loginpage.enterEmail("");
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginpage.enterPassword("");
	}
	
	
//	---------------------- NEWLY ADDED Scenarios -----------------------
	
	
	@Given("user should get Forgotten Password link is available on loginpage")
	public void user_should_get_forgotten_password_link_is_available_on_loginpage() {
		loginpage.isForgotPassLinkPresent();
	}

	@When("user clicks on Forgotten Password link")
	public void user_clicks_on_forgotten_password_link() {
		loginpage.clickForgotPassLink();
	}

	@Then("user should taken to Forgotten Password Page")
	public void user_should_taken_to_forgotten_password_page() {
		forgotpasswordpage = new ForgotPasswordPOM(driver);
		
		forgotpasswordpage.verifyForgotPassPage();
	}

	@When("user press Tab button on his keyboard")
	public void user_press_tab_button_on_his_keyboard() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	

	@Then("user should get proper placeholders for E-Mail Address and Password text fields")
	public void user_should_get_proper_placeholders_for_e_mail_address_and_password_text_fields() {
		loginpage.verifyEmailFieldPlaceholder();
		loginpage.verifyPasswFieldPlaceholder();
	}

	@When("user clicks on browser back button")
	public void user_clicks_on_browser_back_button() {
		driver.navigate().back();
	}

	@When("user clicks on browser forward button")
	public void user_clicks_on_browser_forward_button() {
		driver.navigate().forward();
	}

	@When("user clicks on logout link")
	public void user_clicks_on_logout_link() {
		myaccpage.clickMyaccountMenu();
		myaccpage.clicklogoutOption();
	}

	@Then("user should not get loggedin again")
	public void user_should_not_get_loggedin_again() throws InterruptedException {
		Thread.sleep(1000);

		myaccpage.isLoginedInAgain();
		
		Thread.sleep(3000);
		
	}
	
//	------------------- new valid email and pass steps -------------
	
	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String email) { // for all NON DDT
		loginpage.enterEmail(email);
	}
	
	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passw) { // for all NON DDT
		loginpage.enterPassword(passw);
	}
	
	
	@And ("user closes the browser without logging out his account")
	public void user_closes_the_browser_without_logging_out_his_account() {
		driver.quit();
	}
	@When ("user again natigates to url")
	public void user_again_natigates_to_url() throws IOException {
		driver=WebDriverManager.chromedriver().create();
		
		driver.get(getFromPropertyFile("url"));
		
		
	}
	
	
	

}
