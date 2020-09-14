package onlinelease.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.WebPage;

public class InsuranceAddendumPage extends WebPage{
	
	
	@FindBy(xpath="//label[@for=\"LeaseTerms[0].LeaseTermID\"]")
	private WebElement firstCheckBox;
	
	@FindBy(xpath="//label[@class=\"ps-lease__agreement__checkbox-list__checkboxes__label\"]")
	private List<WebElement> checkBoxes;
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	private WebElement continueBtn;
	
	@FindBy(xpath="//label/b[contains(text(),\"Rolling Ladder Addendum\")]")
	private WebElement rollingLaddTandC;
	

	public InsuranceAddendumPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void insuranceAddm()
	{
		waitFor(ExpectedConditions.visibilityOf(firstCheckBox), 100);
		
		int totalCheckBox = checkBoxes.size();
		
		
		for (int i = 0 ; i<totalCheckBox ; i ++)
		{
			WebElement checkBox = getDriver().findElement(By.xpath("//label[@for=\"LeaseTerms["+ i +"].LeaseTermID\"]"));
			checkBox.click();
			
		}
		
		continueBtn.click();
		
		waitTime(10);
		
		try
		{
			rollingLaddTandC.click();
			continueBtn.click();
		}
		catch(NoSuchElementException nse)
		{
			System.out.println("Not Rolling Ladder avilable");
		}
	}

}
