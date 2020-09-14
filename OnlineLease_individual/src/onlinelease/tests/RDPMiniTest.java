package onlinelease.tests;

import org.testng.annotations.Test;

import onlinelease.constants.TestData;
import onlinelease.constants.WebTest;
import onlinelease.pages.CollectCustomerInfo;
import onlinelease.pages.EmergencyContact;
import onlinelease.pages.FindStorage;
import onlinelease.pages.GetReservationNumber;
import onlinelease.pages.InsuranceAddendumPage;
import onlinelease.pages.InsurancePage;
import onlinelease.pages.PaymentPage;
import onlinelease.pages.RDPMiniPage2;
import onlinelease.pages.RentalAgreementPage;

public class RDPMiniTest extends WebTest {
	
	@Test
	public void rdpMiniTest()
	{
		String zipcode = TestData.zipCode();
		
		FindStorage fs = new FindStorage(getDriver());
		fs.searchUnit(zipcode);
		
		RDPMiniPage2 rdp = new RDPMiniPage2(getDriver());
		rdp.rdpMini();
		
		
		GetReservationNumber rn = new GetReservationNumber(getDriver());
		rn.getReservationNum();
		
		CollectCustomerInfo cci = new CollectCustomerInfo(getDriver());
		cci.collectCustomerPage();
		
		RentalAgreementPage ra = new RentalAgreementPage(getDriver());
		ra.rentalAgreement();
		
		
		InsurancePage ip = new InsurancePage(getDriver());
		ip.reviewOption();
		
		InsuranceAddendumPage iap = new InsuranceAddendumPage(getDriver());
		iap.insuranceAddm();	
		
		EmergencyContact eci = new EmergencyContact(getDriver());
		eci.emergencyInfo();
		
		PaymentPage pp = new PaymentPage(getDriver());
		pp.paymentPage();
		
	}

}
