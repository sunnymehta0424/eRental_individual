package onlinelease.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import onlinelease.constants.TestData;
import onlinelease.constants.WebTest;

public class VerifyHomeTest extends WebTest{
	
	@Test
	public void verifyHomePage() {
		String expectedTitle = TestData.getTitle();
		System.out.println("expected Title : " + expectedTitle);
		String actualTitle = getDriver().getTitle();
		System.out.println("actual Title : " + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
		
	}

}
