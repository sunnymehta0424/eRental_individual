package onlinelease.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import onlinelease.constants.TestData;
import onlinelease.constants.WebTest;
import onlinelease.pages.FindStorage;

public class FindStorageTest extends WebTest {
	
	@Test
	public void findStorage()
	{
		String zipcode = TestData.zipCode();
		System.out.println("Zip code from Test data : " + zipcode);
		
		
		FindStorage fs = new FindStorage(getDriver());
		fs.searchUnit(zipcode);
		
		
		String srpTitle = TestData.srppage();
		System.out.println("SRP Page Title :" + srpTitle);
		
		String srpTitleWeb = getDriver().getTitle();
		
		System.out.println("SRP Title from Website :" + srpTitleWeb);
		
		Assert.assertEquals(srpTitleWeb, srpTitle);
		
		
		
	}

}
