package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.xpath("//input[@name='username']");
    private By passwordInput = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// đợi tối đa 10 giây

        try {
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            usernameField.sendKeys(user);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
            passwordField.sendKeys(pass);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            loginButton.click();
        } catch (TimeoutException e) {
            System.out.println("Element not found or not clickable: " + e.getMessage());
        }
    }
}
