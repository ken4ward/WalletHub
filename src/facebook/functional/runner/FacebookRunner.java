package facebook.functional.runner;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import facebook.functional.constants.FacebookConstants;
import facebook.functional.suites.FacebookSuites;
import facebook.functional.utils.FacebookAssertions;

public class FacebookRunner {

	WebDriver driver;
    private static String SeleniumHubURL;
    private static String TargetServerURL;

    public FacebookRunner()
    {
        SeleniumHubURL = GetConfigurationProperty("SeleniumHubURL", FacebookConstants.SeleniumHubURL);
        TargetServerURL = GetConfigurationProperty("TargetServerURL", FacebookConstants.TestProjectURL);
    }

    private static String GetConfigurationProperty(String environmentKey, String defaultValue)
    {
        String returnValue = defaultValue;
        String environmentValue = System.getenv(environmentKey);

        if (environmentValue != null)
        {
            returnValue = environmentValue;
        }
        return returnValue;
    }
    
    @Test
    public void TestChrome()
    {
        DesiredCapabilities browser = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-notifications");
        browser.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        DesiredCapabilityBrowser(browser);
    }

    public void DesiredCapabilityBrowser(DesiredCapabilities browser)
    {
        try
        {
            driver = new RemoteWebDriver(new URL(SeleniumHubURL), browser);
            driver.get(TargetServerURL);
            driver.manage().window().maximize();
            new FacebookAssertions(driver).WaitForATime(FacebookConstants.PanelBody);
            new FacebookSuites(driver).LoginFacebook();

            new FacebookAssertions(driver).StringContains(FacebookConstants.FacebookPanel);
            new FacebookSuites(driver).PostPage(FacebookConstants.FacebookPostField, FacebookConstants.PostData);
        }
        catch (Exception e)
        {
            System.out.print(e.toString());
        }
        finally
        {
            if (driver != null)
            {
                 driver.close();
            }
        }
    }
	
}
