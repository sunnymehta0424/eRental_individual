package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.WebPage;

public class RentalAgreementPage extends WebPage{
	
	@FindBy(xpath="//label[@for=\"LeaseTerms[0].LeaseTermID\"]/b")
	private WebElement termsConditions1;
	
	@FindBy(xpath="//label[@for=\"LeaseTerms[1].LeaseTermID\"]/b")
	private WebElement termsCondition2;
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	private WebElement continueBtn;
	// Complete My Contactless eRental

	public RentalAgreementPage(WebDriver webDriver) {
		
	
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void rentalAgreement()
	{
		waitFor(ExpectedConditions.visibilityOf(termsConditions1), 100);
		waitTime(3);
		jsClick(termsConditions1);
		
		//termsConditions1.click();
		termsCondition2.click();
		
		
		continueBtn.click();
		

		
	}

}
