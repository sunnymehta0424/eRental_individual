package onlinelease.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.ExcelUtils;
import onlinelease.constants.FilePaths;
import onlinelease.constants.WebPage;

public class RDPMiniPage2 extends WebPage{
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	private List<WebElement> continueBtns;
	
	@FindBy(id="FullName")
	private WebElement fist_Lastname;
	
	@FindBy(xpath="//label[@for=\"PhoneNumber\"]")
	private WebElement phoneNumberLabel;
	
	@FindBy(id="PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(id="EmailAddress")
	private WebElement emailAddress;
	
	@FindBy(xpath="//label[@for=\"MoveInDate\"]")
	private WebElement calenderLabel;
	
	@FindBy(xpath="//button[text()=\"Cancel\"]")
	private WebElement cancel;
	
	
	@FindBy(xpath="//div[contains(@class,\"eRental react-datepicker__day--first-active\")]")
	private WebElement selectDate;
	
	@FindBy(xpath="//button[text()=\"Save\"]")
	private WebElement saveDate;
	
	@FindBy(xpath="//button[text()=\"Hold Unit\"]")
	private WebElement holdUnit;
	
	

	public RDPMiniPage2(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void rdpMini()
	{
		ExcelUtils.setExcelFile(FilePaths.main_file, FilePaths.rdpMini);
		
		String firstLastName = ExcelUtils.getCellData(1, 0);
		System.out.println(firstLastName);
		
		String phoneNbr = ExcelUtils.getCellData(1, 1);
		System.out.println(phoneNbr);
		
		String emailAddrs = ExcelUtils.getCellData(1, 2);
		System.out.println(emailAddrs);
		
		
		// waitFor(ExpectedConditions.visibilityOf(firstContinueBtn), 100);
		
		int totalElements = continueBtns.size();
		
		for (int i=0; i<totalElements; i++) {
			
			int btnIndex = i + 1;
			WebElement continueClick = getDriver().findElement(By.xpath("(//button[text()=\"Continue\"])["+btnIndex +"]"));
			continueClick.click();
			waitTime(5);
			waitFor(ExpectedConditions.visibilityOf(calenderLabel), 50);
			calenderLabel.click();
			
			try {
				selectDate.click();
				waitTime(5);
				saveDate.click();
				
				break;
			}
			catch(NoSuchElementException ne)
			{
				System.out.println("No e rental");
				cancel.click();
			}
			
					
			
		}
		
		waitTime(5);
		
		fist_Lastname.sendKeys(firstLastName);
		
		phoneNumberLabel.click();
		
		phoneNumber.sendKeys(phoneNbr);
		
		emailAddress.sendKeys(emailAddrs);
		
		holdUnit.click();
		
		
	}

}
