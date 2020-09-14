package onlinelease.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import onlinelease.constants.ExcelUtils;
import onlinelease.constants.FilePaths;
import onlinelease.constants.WebPage;

public class ReservationPage extends WebPage {
	
	@FindBy(xpath="//*[@id=\"ps-account-nav\"]/li[2]/label/span")
	private WebElement yourAccountDropDown;
	
	@FindBy(linkText="Your Reservation")
	private WebElement yourReservation;
	
	@FindBy(id="ReservationNumber")
	private WebElement reservationNumber;
	
	@FindBy(id="EmailAddress")
	private WebElement emailAddress;
	
	@FindBy(xpath="//button[text()=\"View Reservation\"]")
	private WebElement viewReservationBtn;
	
	@FindBy(id="cookie-close")
	private WebElement closeCookie;
	
	@FindBy(linkText="COMPLETE MY RENTAL")
	private WebElement completeRentalBtn;

	public ReservationPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	
	public void pullReservation()
	{
		
		waitFor(ExpectedConditions.visibilityOf(closeCookie), 100);
		closeCookie.click();
		
		waitFor(ExpectedConditions.visibilityOf(yourAccountDropDown), 100);
		mouseOver(yourAccountDropDown);
		waitTime(2);
		yourReservation.click();
		waitFor(ExpectedConditions.visibilityOf(reservationNumber), 100);
		ExcelUtils.setExcelFile(FilePaths.main_file, FilePaths.rdpMini);
		// String reservationNum = ExcelUtils.getCellData(1, 3);
		reservationNumber.sendKeys(ExcelUtils.getCellData(1, 3));
		// String emailAddrs = ExcelUtils.getCellData(1, 2);
		emailAddress.sendKeys(ExcelUtils.getCellData(1, 2));
		
		
		
		viewReservationBtn.click();
		
		waitFor(ExpectedConditions.visibilityOf(completeRentalBtn), 100);
		
		completeRentalBtn.click();
		
	}
}
