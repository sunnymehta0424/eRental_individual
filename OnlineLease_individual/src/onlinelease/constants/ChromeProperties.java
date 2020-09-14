package onlinelease.constants;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProperties {
	
	public static String chromepath() {
		String chromePath= System.getProperty("user.dir")+"\\chromedriver.exe";
		return chromePath;
		
		
	}
	public static ChromeOptions chromeprofile() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		return co;
	}

}
