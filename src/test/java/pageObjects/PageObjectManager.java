package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPagePOM landingPagePOM;
	public OffersPagePOM offersPagePOM;
	public AssignmentPOM assignmentPOM;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPagePOM getLandingPagePOM() {
		landingPagePOM = new LandingPagePOM(driver);
		return landingPagePOM;
	}
	
	public OffersPagePOM getOffersPagePOM() {
		offersPagePOM = new OffersPagePOM(driver);
		return offersPagePOM;
	}
	
	public AssignmentPOM getCheckOutPOM() {
		assignmentPOM = new AssignmentPOM(driver);
		return assignmentPOM;
	}
	
	
}
