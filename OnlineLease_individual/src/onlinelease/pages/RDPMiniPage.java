package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.ExcelUtils;
import onlinelease.constants.FilePaths;
import onlinelease.constants.WebPage;

public class RDPMiniPage extends WebPage{
	
	@FindBy(xpath="(//img[@alt=\"eRental logo\"])[1]/parent::div/preceding-sibling::div[1]/button")
	private WebElement firstContinueBtn;
	
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
	
	@FindBy(xpath="//div[contains(@class,\"first-active\")]")
	private WebElement selectDate;
	
	@FindBy(xpath="//button[text()=\"Save\"]")
	private WebElement saveDate;
	
	@FindBy(xpath="//button[text()=\"Hold Unit\"]")
	private WebElement holdUnit;
	
	

	public RDPMiniPage(WebDriver webDriver) {
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
		
		
		waitFor(ExpectedConditions.visibilityOf(firstContinueBtn), 100);
		
		firstContinueBtn.click();
		waitTime(5);
		
		fist_Lastname.sendKeys(firstLastName);
		
		phoneNumberLabel.click();
		
		phoneNumber.sendKeys(phoneNbr);
		
		emailAddress.sendKeys(emailAddrs);
	
		
		calenderLabel.click();
		waitTime(5);
		selectDate.click();
		
		saveDate.click();
		holdUnit.click();
		
		
	}

}
