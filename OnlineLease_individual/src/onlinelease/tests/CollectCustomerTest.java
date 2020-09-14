package onlinelease.tests;

import org.testng.annotations.Test;

import onlinelease.constants.WebTest;
import onlinelease.pages.CollectCustomerInfo;
import onlinelease.pages.ReservationPage;

public class CollectCustomerTest extends WebTest{

	@Test
	public void ccTest()
	{
		ReservationPage rp = new ReservationPage(getDriver());
		rp.pullReservation();
		
		CollectCustomerInfo cci = new CollectCustomerInfo(getDriver());
		cci.collectCustomerPage();
	}
}
