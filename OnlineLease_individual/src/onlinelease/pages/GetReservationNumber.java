package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.ExcelUtils;
import onlinelease.constants.FilePaths;
import onlinelease.constants.WebPage;

public class GetReservationNumber extends WebPage {
	
	@FindBy(xpath="//div[@class=\"ps-lease__customer-info__eRental__reservation\"]/div[1]/a")
	private WebElement reservationNum;
	
	
	@FindBy(id="ps-lease__customer-info__eRental__content__action__button")
	private WebElement completeMyRentalBtn;
	
	@FindBy(id="Customer.Phones[0].PhoneNumber")
	private WebElement phoneNumber;
	
	@FindBy(id="CustomerEmail")
	private WebElement email;
	

	public GetReservationNumber(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	public void getReservationNum()
	{
		waitFor(ExpectedConditions.visibilityOf(reservationNum), 100);
		
		String reservationNumber = reservationNum.getText();
		System.out.println("Reservation Number from web : " + reservationNumber);
		
		/*
		 * if (completeMyRentalBtn.isDisplayed()) { completeMyRentalBtn.click();
		 * waitTime(5); }
		 * 
		 * String phnNum = phoneNumber.getAttribute("value");
		 * System.out.println("Phone Number from Web : " + phnNum);
		 * 
		 * String emailAddr = email.getAttribute("value");
		 * System.out.println("email from Web : " + emailAddr);
		 */
		
		// ExcelUtils.setExcelFile(FilePaths.main_file, FilePaths.rdpMini);
		ExcelUtils.setCellData(FilePaths.main_file, reservationNumber, 1, 3, FilePaths.rdpMini);
		
		
		
		
		
		
	}
	

	
}
