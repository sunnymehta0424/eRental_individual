package onlinelease.constants;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class WebTest {

	private WebDriver primaryDriver;
	
	@BeforeMethod(alwaysRun=true)
	public void beforeTest() 
	{
			System.setProperty("webdriver.chrome.driver",ChromeProperties.chromepath());
			primaryDriver = new ChromeDriver(ChromeProperties.chromeprofile());
			String loadSite=TestData.getUrl();
			primaryDriver.get(loadSite);

	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		// primaryDriver.close();
	}
	
	public WebDriver getDriver() {
		return primaryDriver;
	}
}
