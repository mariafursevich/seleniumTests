package Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCredentials {
        private By usernameLocator = By.cssSelector("input[name='email']");
        private By passwordLocator = By.cssSelector("input[name='password']");
        private By loginButtonLocator = By.cssSelector("button[value='Login']");
        private By lostPasswordButtonLocator = By.cssSelector(".button-set");

        private final WebDriver driver;

public LoginCredentials(WebDriver driver) {
        this.driver = driver;
}
public void attemptLogin(String username, String password){
    driver.findElement(usernameLocator).sendKeys(username);
    driver.findElement(passwordLocator).sendKeys(password);
    driver.findElement(loginButtonLocator).click();
}
public void attemptLostPassword(String username, String password){
    driver.findElement(usernameLocator).sendKeys(username);
    driver.findElement(passwordLocator).sendKeys(password);
    driver.findElement(lostPasswordButtonLocator).click();
}
}
