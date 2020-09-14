package onlinelease.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.WebPage;

public class InsurancePage extends WebPage{
	
	@FindBy(id="insurance-button")
	private WebElement reviewOption;
	
	@FindBy(xpath="//*[@id=\"Username\"]")
	private WebElement userName;
	
	@FindBy(xpath="//*[@id=\"UserPass\"]")
	private WebElement userPass;
	
	@FindBy(xpath="//*[@id=\"Submit1\"]")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//*[@id=\"pssi\"]")
	private WebElement iframeID;

	
	@FindBy(xpath="//*[@id=\"insur-ul-container\"]/ul/li[1]/label")
	private WebElement insuranceOption;
	
	@FindBy(linkText="Continue")
	private WebElement continueInsurance;
	
	public InsurancePage(WebDriver webDriver) {
		super(webDriver);
		
		// TODO Auto-generated constructor stub
	}

	public void reviewOption()
	{
		waitFor(ExpectedConditions.visibilityOf(reviewOption), 100);
		reviewOption.click();
		waitTime(20);
		getDriver().switchTo().frame(iframeID);
		
		try {
			userName.sendKeys("orangedoorst");
			userPass.sendKeys("Mon0722!");
			submitBtn.click();
			waitTime(5);
		}
		catch (NoSuchElementException ne)
		{
			System.out.println("No Login page");
		}
		waitFor(ExpectedConditions.visibilityOf(insuranceOption), 30);
		insuranceOption.click();
		continueInsurance.click();
		getDriver().switchTo().defaultContent();
				
	}
}
