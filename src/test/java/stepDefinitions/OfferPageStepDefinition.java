package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPagePOM;
import pageObjects.OffersPagePOM;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	//public WebDriver driver;
	//public String productNameHome;
	public String productNameOffer;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup =  testContextSetup;
	}
	
	@Then("^User searched with shortname (.+) in offers page$")
	public void user_searched_with_same_shortname_in_offers_page(String shortname) throws InterruptedException {

		searchOffersPage();
		OffersPagePOM offersPagePOM = testContextSetup.pageObjectManager.getOffersPagePOM();
		offersPagePOM.searchItem(shortname);
		
		//WebElement serachOffer = testContextSetup.driver.findElement(By.xpath("//*[@id=\"search-field\"]"));
		//serachOffer.sendKeys(shortname);
		
		Thread.sleep(3000);
		productNameOffer = offersPagePOM.productItemText();
		
		//String productNameOffer = offersPagePOM.productItemText();
		System.out.println();
	}
	
	public void searchOffersPage() {
		
		LandingPagePOM landingPagePOM = testContextSetup.pageObjectManager.getLandingPagePOM();
		//LandingPagePOM lpp = new LandingPagePOM(testContextSetup.driver);
		landingPagePOM.topDealsLink();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page() {
		Assert.assertEquals(testContextSetup.productNameHome, productNameOffer);
	}

}
