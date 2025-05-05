package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    @Parameters({"browser", "nodeUrl"})
    @BeforeMethod
    public void setUp(String browser, String nodeUrl) throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        if(browser.equalsIgnoreCase("chrome")){
            capability.setBrowserName("chrome");
        }else if(browser.equalsIgnoreCase("edge")){
            capability.setBrowserName("MicrosoftEdge");
        }else if (browser.equalsIgnoreCase("firefox")) {
            capability.setBrowserName("firefox");
        }



        driver = new RemoteWebDriver(new URL(nodeUrl), capability);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
