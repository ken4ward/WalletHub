package facebook.functional.reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import facebook.functional.base.Base;
import facebook.functional.constants.FacebookConstants;

public class FacebookReusables extends Base {
	public FacebookReusables() { }
    
    public FacebookReusables(WebDriver driver) {
    	this.driver = driver;
	}

	public String ExpectedResult, ActualResult, Status, Output;
    public Boolean visible = false;
    public WebElement ValidateLogin, ValidateElelmentVisible;
    public String Login;
    public static String Email, Password, ReturnObject;
    
    public static int Count = 0;
    public static int Counting = 0;
    public static String[] lines = { };

    public static String LoginResult = "";

    public void LoginMethod(String Email, String Password)
    {
    	FacebookReusables.Email = Email;
    	FacebookReusables.Password = Password;

        driver.findElement(By.cssSelector(FacebookConstants.EmailField)).clear();
        driver.findElement(By.cssSelector(FacebookConstants.EmailField)).sendKeys(FacebookReusables.Email);

        driver.findElement(By.cssSelector(FacebookConstants.PasswordField)).clear();
        driver.findElement(By.cssSelector(FacebookConstants.PasswordField)).sendKeys(FacebookReusables.Password);

        driver.findElement(By.cssSelector(FacebookConstants.LoginButton)).click();
    }
}
