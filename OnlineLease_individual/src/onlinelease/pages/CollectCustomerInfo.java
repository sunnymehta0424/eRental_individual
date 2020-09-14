package onlinelease.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.ExcelUtils;
import onlinelease.constants.FilePaths;
import onlinelease.constants.WebPage;

public class CollectCustomerInfo extends WebPage{
	
	@FindBy(xpath="//div[@class=\"ps-lease__customer-info__eRental__reservation\"]/div[1]/a")
	private WebElement reservationNum;
	
	@FindBy(id="ps-lease__customer-info__eRental__content__action__button")
	private WebElement completeMyRentalBtn;
	
	//@FindBy(id="IsMobilePhoneAndTextingOk")
	@FindBy(xpath="//label[@for=\"IsMobilePhoneAndTextingOk\"]")
	private WebElement testGateCodeok;
	
	@FindBy(xpath="//label[@for=\"BusinessNo\"]")
	private WebElement businessNo;
	
	@FindBy(xpath="//label[@for=\"MilitaryNo\"]")
	private WebElement militaryNo;
	
	@FindBy(id="Username")
	private WebElement Username;
	
	@FindBy(id="Password")
	private WebElement password;
	
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="Customer.Address.AddressLine1")
	private WebElement AddressLine1;
	
	@FindBy(id="Customer.Address.AddressLine2")
	private WebElement AddressLine2;
	
	@FindBy(id="Customer.Address.City")
	private WebElement city;
	
	@FindBy(xpath="//label[@for=\"Customer.Address.StateCode\"]/preceding-sibling::div[1]/div[@class=\"Select-control\"]")
	private WebElement addressState;
	
	//div[@class="Select-option"][text()="CA"]
	
	@FindBy(xpath="//div[@class=\"Select-menu-outer\"]/div/div[@class=\"Select-option\"][text()=\"CA\"]")
	private WebElement stateVal;
	
	@FindBy(id="Customer.Address.PostalCode")
	private WebElement PostalCode;
	
	@FindBy(xpath="//label[@for=\"Customer.Identification.IdentificationTypeID\"]/preceding-sibling::div[1]/div[@class=\"Select-control\"]")
	private WebElement lblIdentificationTypeID;
	
	@FindBy(xpath="//div[text()=\"Driver's License\"]")
	private WebElement diverLicense;
	
	@FindBy(xpath="//label[@for=\"Customer.Identification.StateTypeID\"]/preceding-sibling::div[1]/div[@class=\"Select-control\"]")
	private WebElement lblIdentificationState;
	
	@FindBy(id="Customer.Identification.IDValue")
	private WebElement identificationValue;
	
	@FindBy(xpath="//div[@class=\"ps-lease__customer-info__form__button\"]/button")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//label[@for=\"entered-address\"]")
	private WebElement enteredAddress;
	
	@FindBy(id="BirthYear")
	private WebElement birthYear;
	
	

	public CollectCustomerInfo(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void collectCustomerPage()
	{
		
		ExcelUtils.setExcelFile(FilePaths.main_file, FilePaths.ccinfo);
		
		String pwdVal = ExcelUtils.getCellData(1, 0);
		
		String cfmpwdVal = ExcelUtils.getCellData(1, 1);
		
		String addrs1 = ExcelUtils.getCellData(1, 2);
		
		String addrs2 = ExcelUtils.getCellData(1, 3);
		
		String cityVal = ExcelUtils.getCellData(1, 4);
		
		String zipcode = ExcelUtils.getCellData(1, 5);
		
		String identification = ExcelUtils.getCellData(1, 6);
		
		waitFor(ExpectedConditions.visibilityOf(reservationNum), 100);
		
		/*
		 * if (completeMyRentalBtn.isDisplayed()) { completeMyRentalBtn.click();
		 * waitTime(5); }
		 */
		try 
		{
			completeMyRentalBtn.click();
		}
		catch(NoSuchElementException ne)
		{
			System.out.println("NO complete my rental button");
		}
		
		testGateCodeok.click();
		
		businessNo.click();
		
		militaryNo.click();
		
		
		
		
		password.sendKeys(pwdVal);
		
		confirmPassword.sendKeys(cfmpwdVal);
		
		AddressLine1.sendKeys(addrs1);
		
		AddressLine2.sendKeys(addrs2);
		
		city.sendKeys(cityVal);
		
		addressState.click();
		
		// jsClick(addressState);
		
		
		stateVal.click();
		
		PostalCode.sendKeys(zipcode);
		
		lblIdentificationTypeID.click();
		
		// jsClick(lblIdentificationTypeID);
		
		diverLicense.click();
		
		//jsClick(lblIdentificationState);
		
		 lblIdentificationState.click();
		
		stateVal.click();		
		
		identificationValue.sendKeys(identification);
		
		birthYear.sendKeys("2020");
		
		waitTime(5);
		
		continueButton.click();
		
		waitTime(5);
		
		waitFor(ExpectedConditions.visibilityOf(enteredAddress), 100);
		enteredAddress.click();
		
		try
		{
			Username.clear();
			
			jsWrite(Username, "");
			// waitTime(2);
			ExcelUtils.setExcelFile(FilePaths.main_file, FilePaths.rdpMini);
			// Username.sendKeys(ExcelUtils.getCellData(2, 2));
			String username2 = ExcelUtils.getCellData(2, 2);
			Username.sendKeys(username2);
			// jsWrite(Username, username2);
		}
		catch(NoSuchElementException nse)
		{
			System.out.println("No username box");
		}
		
		
		
				
		waitTime(5);
		
		continueButton.click();
		
	}
	

}
