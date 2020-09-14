package onlinelease.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public  class TestData {
	
	public static Properties loadConfigFile() {
		File file = new File( System.getProperty("user.dir")+"\\dataconfig.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getUrl()
	{
	
		String value=loadConfigFile().getProperty("homeURL");
		return value;
	}
	public static String zipCode()
	{
		String value=loadConfigFile().getProperty("zipCode");
		return value;
	}
	public static String getTitle()
	{
		String value=loadConfigFile().getProperty("getTitle");
		return value;
	}
	public static String srppage()
	{
		String value=loadConfigFile().getProperty("srppage");
		return value;
	}
	
	
	
	
	

}
