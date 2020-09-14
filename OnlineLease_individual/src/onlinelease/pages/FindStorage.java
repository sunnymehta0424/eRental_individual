package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.WebPage;

public class FindStorage extends WebPage{

	@FindBy(name="location")
	private WebElement searchLocation;
	
	@FindBy(className="ps-findstorage__search__form__button")
	private WebElement findStorgebutton;
	
	@FindBy(id="cookie-close")
	private WebElement closeCookie;
	
	
	
	public FindStorage(WebDriver webDriver) {
		super(webDriver);
	}

	public void searchUnit(String zipcode)
	
	{
		waitFor(ExpectedConditions.visibilityOf(closeCookie), 100);
		closeCookie.click();
		
		waitFor(ExpectedConditions.visibilityOf(searchLocation), 100);
		
		searchLocation.clear();
		searchLocation.sendKeys(zipcode);
		
		findStorgebutton.click();		
		waitTime(10);
	}
}
