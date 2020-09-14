package onlinelease.constants;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class WebPage {
	 	private final WebDriver webDriver;
	 	private final Actions actions;
	    private final SoftAssert pageValidator;
	   
	 	public WebPage(WebDriver webDriver) {
	        this.webDriver = webDriver;
	        this.actions = new Actions(webDriver);
	        this.pageValidator = new SoftAssert();
	        initPage();
	    }
	 	
	 	private void initPage() {
	 		PageFactory.initElements(webDriver, this);
	        validate();
	    }
	 	/**
	     * Validate method is called once the page is initialized, sub classes need to override this method for verifying if
	     * the page is valid.
	     */
	    protected void validate() {
	        // no implementation.
	    }
	    /**
	     * Wait for condition usign the fluent driver
	     * 
	     * @param waitCondition
	     */
	    public void waitFor(ExpectedCondition<?> waitCondition, long timeout) {
	        new WebDriverWait(webDriver, timeout).pollingEvery(500, TimeUnit.MILLISECONDS).until(waitCondition);
	    }
	    
	    
	    public void jsWrite(WebElement elementVal, String valueTxt)
	    {
	    	JavascriptExecutor jse = (JavascriptExecutor)getDriver();
	    	// jse.executeScript("document.getElementById('"+elementVal+"').value='"+ valueTxt +"';");
	    	// jse.executeScript("arguments[0].setAttribute('value', '"+ valueTxt +"')",elementVal);
	    	jse.executeScript("arguments[0].value='"+ valueTxt +"';", elementVal);
	    	
	    }
	    
	    public void jsClick(WebElement elementVal)
	    {
	    	JavascriptExecutor executor = (JavascriptExecutor)getDriver();
	    	executor.executeScript("arguments[0].click();", elementVal);
	    }
	    /**
	     * selects value from drop down box using the condition SelectElement
	     * 
	     * @param SelectCondition
	     */
	   
	    public void selectElements(WebElement mySelectElmnt,String visibleText)
	    {
	    	Select mySelect= new Select(mySelectElmnt);
	    	mySelect.selectByVisibleText(visibleText);
	    }
	  
	    /**
	     * Scroll element
	     * 
	     * @param ScrollCondition
	     */
	   
	    public void scrollElement(WebElement element)
	    {
	    	((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
	    
	    
	    /**
	     * @return the webDriver
	     */
	    public WebDriver getDriver() {
	        return webDriver;
	    }
	    /**
	     * Returns actions class that will return the gestures that can be done on the web elements.
	     * 
	     * @return
	     */
	    protected Actions exec() {
	        return actions;
	    }

	    /**
	     * Performs mouse actions on the given element
	     * 
	     * @param element
	     */
	    protected void mouseOver(WebElement element) {
	        actions.moveToElement(element).perform();
	    }
	  	    /**
	     * Returns the page validator that can be used to validate page details.
	     * 
	     * @return the pageValidator
	     */
	    public SoftAssert validator() {
	        return pageValidator;
	    }
	    /**
	     * Returns the title associated with web page.
	     * 
	     * @return
	     */
	    public String title() {
	        return webDriver.getTitle();
	    }

	    /**
	     * Verifies if the page is valid or not using the asserts.
	     * 
	     * @return
	     */
	    public boolean isPageValid() {
	        boolean isValid = false;
	        try {
	            pageValidator.assertAll();
	            isValid = true;
	        } catch (AssertionError error) {
	            isValid = false;
	        }
	        return isValid;
	    }

	    public void waitTime(int wtTime)
	    {
	    	try {
	    		wtTime=wtTime*1000;
				Thread.sleep(wtTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
