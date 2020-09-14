package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import onlinelease.constants.WebPage;

public class PaymentPage extends WebPage{
	
	@FindBy(xpath="//label[@for=\"ESign\"]")
	private WebElement eSign;
	
	@FindBy(xpath="//label[@for=\"IsValidTerms\"]")
	private WebElement tandC;
	
	@FindBy(xpath="//label[@for=\"Sweepstakes\"]")
	private WebElement sweepStakes;

	
	@FindBy(xpath="//label[@for=\"CardPayment\"]")
	private WebElement cardPayment;
	
	@FindBy(id="ccNumber")
	private WebElement creditCardNum;
	
	@FindBy(id="expMonth")
	private WebElement expirationMonth;
	
	@FindBy(id="expYear")
	private WebElement expirationYear;
	
	
	@FindBy(id="completeButton")
	private WebElement completeBtn;
	
	
	//@FindBy(xpath="")
	//private WebElement 
	

	public PaymentPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void paymentPage()
	
	{
		
		waitFor(ExpectedConditions.visibilityOf(eSign), 100);
		eSign.click();
		tandC.click();
		sweepStakes.click();
		cardPayment.click();
		
		getDriver().switchTo().frame(0);
		creditCardNum.sendKeys("341134113411347");
		
		Select selectMonth = new Select(expirationMonth);
		selectMonth.selectByIndex(1);
		
		Select selectYear = new Select(expirationYear);
		selectYear.selectByVisibleText("2022");
		
		// selectElements(expirationMonth,"02");
		
		completeBtn.click();
		
		getDriver().switchTo().defaultContent();
		
		
		
	}
	
	

}
