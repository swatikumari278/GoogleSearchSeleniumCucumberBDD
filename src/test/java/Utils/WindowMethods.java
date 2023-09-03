package Utils;

import org.openqa.selenium.*;


public class WindowMethods {
	
	private WebDriver driver;
	private String old_win = null;
	private String lastWinHandle;
	
	public WindowMethods(WebDriver driver) {
		this.driver = driver;
	
	}
	
	/**Method to switch to new window */
    public void switchToNewWindow()
    {
    	old_win = driver.getWindowHandle();
    	for(String winHandle : driver.getWindowHandles())
    		lastWinHandle = winHandle;
    	driver.switchTo().window(lastWinHandle);
    }
    
    /** Method to switch to old window */
    public void switchToOldWindow()
    {
    	driver.switchTo().window(old_win);
    }
    
    /** Method to switch to window by title*/
   public void switchToWindowByTitle(String windowTitle) throws Exception
    {
    	old_win = driver.getWindowHandle();
    	boolean winFound = false;
    	for(String winHandle : driver.getWindowHandles())
    	{
    		String str = driver.switchTo().window(winHandle).getTitle();
    		if (str.equals(windowTitle))
    		{   winFound = true;
    			break;
    		}
    	}
    	if (!winFound)
    		throw new Exception("Window having title "+windowTitle+" not found");
    }
   /**Method to close new window*/
    public void closeNewWindow()
    {
    	driver.close();
    }
}
