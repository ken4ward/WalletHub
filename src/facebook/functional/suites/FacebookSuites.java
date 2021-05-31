package facebook.functional.suites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import facebook.functional.base.Base;
import facebook.functional.constants.FacebookConstants;
import facebook.functional.reusables.FacebookReusables;

public class FacebookSuites extends Base {
	public FacebookSuites() { }
    public FacebookSuites(WebDriver driver) { 
    	this.driver = driver;
    }
    
    public static String[] ParametersValuesOne = { FacebookConstants.EmptyParameter, FacebookConstants.ValidEmail };
    public static String[] ParametersValuesTwo = { FacebookConstants.WrongParameter, FacebookConstants.ValidPassword };

    public void LoginFacebook()
    {
    	FacebookReusables facebookReusables = new FacebookReusables(driver);
        for(String valueOne : FacebookSuites.ParametersValuesOne)
        {
            for(String valueTwo : FacebookSuites.ParametersValuesTwo)
            { 
              facebookReusables.LoginMethod(valueOne, valueTwo); 
              System.out.printf(valueOne, valueTwo);
            }
        }
    }

    public void PostPage(String Postdata, String DataPosted)
    {
        driver.findElement(By.cssSelector("textarea[name='xhpc_message']")).click();
        driver.findElement(By.cssSelector("textarea[name='xhpc_message']")).sendKeys("Hello World");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[.=\"Post\"]"))).click();
    }
}
