package step_defination;
import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pom.HomepagePOM;
import pom.MyaccountpagePOM;
import pom.SearchPOM;
import pom.ShoppingCartPOM;
import pom.WishListPOM;
import utilities.Baseclass;


public class SearchSD extends Baseclass {
	
	
	@Given("User opens the Application")
	public void user_opens_the_application() throws IOException {
		
		driver.get(getFromPropertyFile("url"));
		homepage = new HomepagePOM(driver);
	}
	
	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String productname) {
		
		myaccpage=new MyaccountpagePOM(driver);
		myaccpage.enterTextInSearchField(productname);
	}
	
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		myaccpage=new MyaccountpagePOM(driver);
		myaccpage.clickSearchButton();
		
	}
	
	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() throws InterruptedException {
		
		
		searchpage = new SearchPOM(driver);
		searchpage.verifySearchResult() ;
		
	}
	
	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
		homepage.enterTextInSearchField(invalidProduct);
	}
	
	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		myaccpage = new MyaccountpagePOM(driver);
		myaccpage.verifyNoProductWarning();
	}
	
	@When("User dont enter any product name into Search box field")
	public void User_dont_enter_any_product_name_into_Search_box_field() {
		homepage.enterTextInSearchField("");
	}
	
	
//	--------------------------------------------------------------------------------------------
	
	@Then("User should get valid product displayed page in search results")
	public void user_should_get_valid_product_displayed_page_in_search_results() throws InterruptedException {		
		
		searchpage = new SearchPOM(driver);
		searchpage.verifySearchResult() ;
		
	}

	@Then("user should get proper placeholder for search field")
	public void user_should_get_proper_placeholder_for_search_field() {
	    homepage.verifyPlaceHolderSearchField();
	   
	}

	@Then("user should navigates to the search page")
	public void user_should_navigates_to_the_search_page() {
	    
		searchpage = new SearchPOM(driver);
		
		searchpage.verifyPageTitleSearchPage();
	}

	

	@Then("user clicks on Grid view button")
	public void user_clicks_on_grid_view_button() {
		
		searchpage = new SearchPOM(driver);
		
		searchpage.clickGridBtn();
	}

	@Then("user should get proper productname description and price in searched result")
	public void user_should_get_proper_productname_description_and_price_in_searched_result() {
		searchpage.verifyiPhoneProductName();
		searchpage.verifyiPhoneDescription();
		searchpage.verifyiPhonePrice();
	   
	}


	@When("user clicks on add to Cart button")
	public void user_clicks_on_add_to_cart_button() {
	    searchpage.clickaddToCartIcon();
	   
	}

	@Then("user should get confirmation message for add to cart")
	public void user_should_get_confirmation_message_for_add_to_cart() {
	    searchpage.verifyaddTocartConfirmMsg();
	   
	}


	@When("user clicks on add to Wishlist button")
	public void user_clicks_on_add_to_wishlist_button() {
	    
		searchpage.clickWishlistButton(); 
	}

	@Then("user should get proper warning message for wishlist")
	public void user_should_get_proper_warning_message_for_wishlist() {
	    
	   searchpage.verifywishlistWarning();
	}

	@Then("user should get proper success message for wish list")
	public void user_should_get_proper_success_message_for_wish_list() {
	    
	   searchpage.verifyWishListSuccessMsg();
	}

	@Then("added product should be present inside My wishlist")
	public void added_product_should_be_present_inside_my_wishlist() {
	    wishlistpage = new WishListPOM(driver);
	    
	    searchpage.clickWishlistMenu();
	    
	    Assert.assertTrue(wishlistpage.searchProdByPriceWishListPage(), "Product present in Table of Wishlist");
	   
	}
	
	@Then("added product should be present inside Shopping cart")
	public void added_product_should_be_present_inside_shopping_cart() {
	   
		shoppingcartpage = new ShoppingCartPOM(driver);
		
		searchpage.clickShoppingCartMenu();
		
		
		 Assert.assertTrue(shoppingcartpage.searchbyPriceShoppingCartPage(), "Product present in Table of Shopping cart");
	   
	}
	
	
	@And ("user clicks on Shopping cart menu")
	public void user_clicks_on_Shopping_cart_menu() {
		
		searchpage.clickShoppingCartMenu();
	}
	
	@And ("user clicks on wishlist cart menu")
	public void user_clicks_on_wishlist_cart_menu() {
		
		searchpage.clickWishlistMenu();
	}

}
