package facebook.functional.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import facebook.functional.base.Base;

public class FacebookAssertions extends Base {
	public FacebookAssertions() { }
    public FacebookAssertions(WebDriver driver) {
    	this.driver = driver;
    }

    public void WaitTime()
    {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    public void WaitForATime(String InputPathLocator)
    {
        WebDriverWait tests = new WebDriverWait(driver, 180);
        tests.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(InputPathLocator)));
    }

    
    public void AssertElementPresent(String AssertedElement, String PostedReview)
    {
        String actualvalue = driver.findElement(By.cssSelector(AssertedElement)).getText();
         Assert.assertTrue(actualvalue.contains(PostedReview));
    }
    
    public void StringContains(String ElementCheck)
    {
        List<WebElement>  myelements = driver.findElements(By.cssSelector(ElementCheck));
        for (WebElement elements : myelements)
        {
            WaitForATime(elements.getText());
        }

    }
}
