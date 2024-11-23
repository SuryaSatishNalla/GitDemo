package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPagePOM;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	//public WebDriver driver;
	public String productNameHome;
	public String productNameOffer;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPagePOM landingPagePOM;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPagePOM = testContextSetup.pageObjectManager.getLandingPagePOM();
	}
	
	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() throws IOException {

       Assert.assertTrue(landingPagePOM.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with shortname (.+) in home page and extracted actual name of product$")
	public void user_searched_with_shortname_in_home_page_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {

	    //pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//instaed of creating object for for the line 42 we can use TestContextSetup
		
		landingPagePOM.searchItem(shortname);
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		
		Thread.sleep(3000);
		testContextSetup.productNameHome = landingPagePOM.productItemText().split("-")[0].trim();
		
		
		System.out.println(testContextSetup.productNameHome+ " is extracted from Home page");
	}
	
	@When("Added {string} items of selected product to cart")
    public void Added_items_of_selected_product_to_cart(String quantity)
    {
		landingPagePOM.incrementQuantity(Integer.parseInt(quantity));
		landingPagePOM.addToCart();
    }


}
