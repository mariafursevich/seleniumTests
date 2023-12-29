package Task2;

import Task3.NavigationInCatalog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTests {

    @Test
    public void openingMainPage () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        WebElement title = driver.findElement(By.cssSelector("div[id='box-most-popular'] h3[class='title']"));
        Assert.assertTrue(title.isDisplayed());
        driver.quit();
    }
    @Test
    public void openingRubberDucksCatalog (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        new NavigationInCatalog().navigationInCatalog(driver);
        WebElement categories = driver.findElement(By.cssSelector(".listing-wrapper.products"));
        Assert.assertTrue(categories.isDisplayed());
        driver.quit();
    }
    @Test
    public void openingRubberDucksSubcategory (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        new Certificate(driver).acceptCertificate();
        Actions builder = new Actions(driver);
        WebElement catalog = driver.findElement(By.xpath("//li[@class='category-1']//a[contains(text(),'Rubber Ducks')]"));
        builder.moveToElement(catalog).perform();
        WebElement subCategory = driver.findElement(By.xpath("//li[@class='category-1']//a[contains(text(),'Subcategory')]"));
        builder.moveToElement(subCategory).click().perform();
        WebElement categories = driver.findElement(By.xpath("//h1[@class='title']"));
        Assert.assertTrue(categories.isDisplayed());
        driver.quit();
    }
}
