package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPagePOM {

	public WebDriver driver;
	public OffersPagePOM(WebDriver driver) {
		this.driver = driver;
		
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]");
	
	public void searchItem(String name) {

		driver.findElement(search).sendKeys(name);
	}
	
	public String productItemText() {
		return driver.findElement(productName).getText();
	}
	

	
}
