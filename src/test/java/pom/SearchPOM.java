package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPOM {
	
	public WebDriver driver;
	
	public SearchPOM (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	public void verifyPageTitleSearchPage() {
		Assert.assertEquals(driver.getTitle(), "Search");
	}
	
	

	
	@FindBy (xpath = "//button[@id='grid-view']")
	public WebElement gridButton;
	
	public void clickGridBtn () {
		gridButton.click();
	}
	
	
	
	@FindBy (xpath = "//a[.='iPhone']")
	public WebElement iPhoneProductName ;
	
	public void verifyiPhoneProductName () {
		Assert.assertEquals(iPhoneProductName.getText(), "iPhone");
	}
	
	@FindBy (xpath = "//p[contains(text(),'iPhone is a revolutionary new mobile phone that al')]")
	public WebElement iPhoneDescription ;
	
	public void verifyiPhoneDescription () {
		Assert.assertTrue(iPhoneDescription.isDisplayed(), "Description should be display");
	}
	
	@FindBy (xpath = "//p[@class='price']")
	public WebElement iPhonePrice ;
	
	
	@FindBy (xpath = "//span[normalize-space()='Shopping Cart']")
	public WebElement ShoppingCartMenu;
	
	public void clickShoppingCartMenu () {
		ShoppingCartMenu.click();;
	}
	
	
	@FindBy (xpath = "//span[normalize-space()='Wish List (1)']")
	public WebElement WishlistMenu;
	
	public void clickWishlistMenu () {
		WishlistMenu.click();
	}
	
	public void verifyiPhonePrice () {
		Assert.assertTrue(iPhonePrice.isDisplayed(), "Price should be display");
	}
	
	
	@FindBy (xpath = "(//select[@id='input-sort'])[1]")
	public WebElement sortBy;
	
	public void verifysortBy () {
		Assert.assertEquals(sortBy.getText(), "Default");
	}
	
	
	@FindBy (xpath = "//span[normalize-space()='Add to Cart']")
	public WebElement addToCartIcon;
	
	public void clickaddToCartIcon () {
		addToCartIcon.click();
	}
	
	
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement addTocartConfirmMsg ;
	
	public void  verifyaddTocartConfirmMsg() {
		Assert.assertTrue(addTocartConfirmMsg.isDisplayed());
	}
	
	
	
	
	@FindBy (xpath = "(//button[@type='button'])[10]")
	public WebElement WishlistButton ;
	
	public void clickWishlistButton () {
		WishlistButton.click();
	}
	
	
	
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement wishlistWarning;
	
	public void verifywishlistWarning() {
		Assert.assertTrue(wishlistWarning.isDisplayed());
	}
	
	
	
	
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement WishListSuccessMsg ;
	
	public void verifyWishListSuccessMsg () {
		Assert.assertTrue(WishListSuccessMsg.isDisplayed());
	}
	
	
	
	
	@FindBy (xpath = "(//h2[normalize-space()='Products meeting the search criteria'])[1]")
	public WebElement searchResultSuccessHeading;
	
	public void verifySearchResult() {
		 
		 Assert.assertTrue(searchResultSuccessHeading.isDisplayed());
	}
	

}
