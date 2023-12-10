package Task3;

import Task2.Certificate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTests {
    private WebDriver driver;

    @Test
    public void productInBasket() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        LoginCredentials loginCredentials = new LoginCredentials(driver);
        loginCredentials.attemptLogin("test@test.com", "1234567");
        Actions builder = new Actions(driver);
        WebElement catalog = driver.findElement(By.xpath("//li[@class='category-1']//a[contains(text(),'Rubber Ducks')]"));
        builder.moveToElement(catalog).click().perform();
        new ProductCardSelection().ProductSelection(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Checkout »']")).click();
        String orderSummary = driver.findElement(By.xpath("//h2[normalize-space()='Order Summary']")).getText();
        Assert.assertTrue(orderSummary.contains("Order Summary"));
        driver.quit();
    }
}
