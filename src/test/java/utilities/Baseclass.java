package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pom.AccountCreateSuccessPOM;
import pom.ContactUsPOM;
import pom.ForgotPasswordPOM;
import pom.HomepagePOM;
import pom.LoginpagePOM;
import pom.MyaccountpagePOM;
import pom.PhonesModulePOM;
import pom.RegistrationPagePOM;
import pom.SearchPOM;
import pom.ShoppingCartPOM;
import pom.WishListPOM;



public class Baseclass {
	
	
	
	public static WebDriver driver;			// If static then only one step def class having hooks will work
	
//	-----------------------------------------------------------------------------------

	
	public HomepagePOM homepage;
	public LoginpagePOM loginpage;
	public MyaccountpagePOM myaccpage;
	public RegistrationPagePOM registeraccpage;
	public AccountCreateSuccessPOM accSuccesspage;
	public ForgotPasswordPOM forgotpasswordpage;
	public PhonesModulePOM phonespage;
	public SearchPOM searchpage;
	
	public  WishListPOM wishlistpage;
	public ShoppingCartPOM shoppingcartpage;
	public ContactUsPOM contactuspage;
	
	public Properties p;
	
//	-----------------------------------------------------------------------------------

	
	public String getFromPropertyFile(String key) throws IOException {
		p=new Properties();
		FileInputStream fis = new FileInputStream("config.properties");
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	
//	-----------------------------------------------------------------------------------

	
	
	public String randomEmail() {
		
		return (RandomStringUtils.randomAlphabetic(5) + "@gmail.com");
	}
	
//	-----------------------------------------------------------------------------------

	
	
}
