package pom;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPOM {
	
public WebDriver driver;
	
	public ShoppingCartPOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	public void verifypageTitleShoppingcartpage() {
		Assert.assertEquals(driver.getTitle(), "Shopping Cart");
	}
	
	
	
	
		@FindBy (xpath = "(//table[@class='table table-bordered'])[2]//tbody/tr")
		List<WebElement> tableRows;
		
	
		
		
	public boolean searchbyPriceShoppingCartPage() {
		
		boolean found = false;
		
	int	ttRows =  tableRows.size();
	
	for (int i = 1; i <= ttRows ; i++) {
		
		WebElement pricebox = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[2]//tbody/tr["+i+"]/td[5]"));
		
		String actualprice = pricebox.getText();
		System.out.println("-------------------------------------------------------------------------------"+actualprice);
		
		if (actualprice.equalsIgnoreCase("$101.00")) {
			found = true;
		}
	
	}
	
	return found;
		
	}
		
		

}
