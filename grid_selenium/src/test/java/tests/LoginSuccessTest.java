package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginSuccessTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dashboardElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']"))
        );

        boolean isDashboardVisible = dashboardElement.isDisplayed();
        Assert.assertTrue(isDashboardVisible, "Dashboard should be visible after login.");
    }
}
