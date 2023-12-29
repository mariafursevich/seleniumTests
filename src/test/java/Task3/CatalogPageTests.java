package Task3;

import Task2.Certificate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CatalogPageTests {
  @Test
    public void productOnSale(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        new NavigationInCatalog().navigationInCatalog(driver);
        WebElement yellowDuck = driver.findElement(By.xpath("//img[@alt='Yellow Duck']"));
        WebElement sale = driver.findElement(By.xpath("//div[@title='On Sale']"));
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(yellowDuck.isDisplayed());
        Assert.assertTrue(sale.isDisplayed());
        softAssert.assertAll();
        driver.quit();
    }
    @Test
    public void productOnSaleFullCard(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        new NavigationInCatalog().navigationInCatalog(driver);
        driver.findElement(By.xpath("//img[@alt='Yellow Duck']")).click();
        WebElement photo = driver.findElement(By.xpath("//img[@title='Yellow Duck']"));
        Assert.assertTrue(photo.isDisplayed());
        driver.quit();
    }
    @Test
    public void productOnSalePrice(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        new NavigationInCatalog().navigationInCatalog(driver);
        driver.findElement(By.xpath("//img[@alt='Yellow Duck']")).click();
        String salePrice = driver.findElement(By.xpath("//strong[@class='campaign-price']")).getText();
        Assert.assertEquals("$18", salePrice);
        driver.quit();
    }




}
