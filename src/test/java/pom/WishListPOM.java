package pom;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WishListPOM {
	
public WebDriver driver;
	
	public WishListPOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	
	
	public void verifypageTitleWishlistpage() {
		Assert.assertEquals(driver.getTitle(), "My Wish List");
	}
	
		
	
	@FindBy (xpath = "//table[@class='table table-bordered table-hover']//tbody/tr")
	List<WebElement> tableRows;
	
	
	
	public boolean searchProdByPriceWishListPage() {
		
		
		
		boolean found = false;
		
		int ttRows = tableRows.size();
		
		for (int i = 1; i <= ttRows; i++) {
			
			System.out.println("Searching row:" +i );
			
			WebElement pricebox=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+i+"]/td[5]"));
		
			String actualprice = pricebox.getText();
			
			if (actualprice.equalsIgnoreCase("$101.00")) {
				found = true;
			}
		
		}
		
		return found;
	}

}
