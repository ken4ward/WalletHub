/**
 * 
 */
package facebook.functional.base;

import org.openqa.selenium.WebDriver;

/**
 * @author Kadeoya
 *
 */
public class Base {
	public WebDriver driver;
    public Base() { }

    //The instance is paased as an argument to the class constructor
    public Base(WebDriver driver)
    {
        this.driver = driver;
    }
}
