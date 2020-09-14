package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.WebPage;

public class EmergencyContact extends WebPage{
	

	@FindBy(linkText="Skip")
	private WebElement skipECI;
	
	
	
	public EmergencyContact(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void emergencyInfo()
	
	{
		waitFor(ExpectedConditions.visibilityOf(skipECI), 100);
		skipECI.click();
		
	}
	
	
	
	

}
