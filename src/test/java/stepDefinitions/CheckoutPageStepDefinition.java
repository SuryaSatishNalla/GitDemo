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
import pageObjects.AssignmentPOM;
import pageObjects.LandingPagePOM;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	//public WebDriver driver;
	public String productNameHome;
	public String productNameOffer;
	public AssignmentPOM assignmentPOM;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.assignmentPOM = testContextSetup.pageObjectManager.getCheckOutPOM();

	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void Verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(assignmentPOM.promocodeDisplay());
		Assert.assertTrue(assignmentPOM.plcaeorderDisplay());

	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_and_validate_the(String name) throws InterruptedException
	{
		assignmentPOM.addToCartBag();
		Thread.sleep(3000);
	}

}
