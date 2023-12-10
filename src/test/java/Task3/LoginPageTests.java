package Task3;


import Task2.Certificate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests {
    @Test
    public void validCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        LoginCredentials loginCredentials = new LoginCredentials(driver);
        loginCredentials.attemptLogin("test@test.com", "1234567");
        WebElement successAlert = driver.findElement(By.cssSelector(".notice.success"));
        Assert.assertTrue(successAlert.isDisplayed());
        driver.quit();
    }
    @Test
    public void invalidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        LoginCredentials loginCredentials = new LoginCredentials(driver);
        loginCredentials.attemptLogin("test@test.com", "1234");
        WebElement successAlert = driver.findElement(By.cssSelector(".notice.errors"));
        Assert.assertTrue(successAlert.isDisplayed());
        driver.quit();
    }
    @Test
    public void lostPassword() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        LoginCredentials loginCredentials = new LoginCredentials(driver);
        loginCredentials.attemptLostPassword("test@test.com", "");
        String lostPasswordAlert = driver.findElement(By.cssSelector(".notice.success")).getText();
        Assert.assertEquals("A new password has been sent to your email address.", lostPasswordAlert);
        driver.quit();
    }
}
