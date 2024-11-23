package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignmentPOM {

	public WebDriver driver;
	public AssignmentPOM(WebDriver driver) {
		this.driver = driver;
		
	}
	By quantity = By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[2]/input");
	By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By addToCartBag = By.xpath("//a[@class='cart-icon']");
	By checkout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By productValidate = By.cssSelector("p.product-name");
	By promocode = By.cssSelector("button.promoBtn");
	By placeOrder = By.xpath("//*[@id=\"root\"]/div/div/div/div/button");

	public void quantityClear() {

		driver.findElement(quantity).clear();
	}
	
	public void quantityAdd(String qty) {
		
		driver.findElement(quantity).sendKeys(qty);
	}
	
	public void addToCartClick() {
		
		driver.findElement(addToCart).click();
	}
	
	
	public void addToCartBag() {
		
		driver.findElement(addToCartBag).click();
		driver.findElement(checkout).click();

	}
	
	public String productValidateText() {
		return driver.findElement(productValidate).getText();
	}
	
	public Boolean promocodeDisplay() {
		return driver.findElement(promocode).isDisplayed();
	}
	
	public Boolean plcaeorderDisplay() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}
