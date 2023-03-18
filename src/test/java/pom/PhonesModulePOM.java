package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PhonesModulePOM {

	public WebDriver driver;
	
	public PhonesModulePOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver , this);
	}
	
	
	
	
	public void verifyPhonesPage() {
		
		Assert.assertEquals( driver.getTitle(), "Phones & PDAs" );
	}
}
