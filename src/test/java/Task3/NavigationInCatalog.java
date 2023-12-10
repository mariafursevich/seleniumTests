package Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationInCatalog {
    WebDriver driver;
    public void navigationInCatalog(WebDriver driver){
        Actions builder = new Actions(driver);
        WebElement catalog = driver.findElement(By.xpath("//li[@class='category-1']//a[contains(text(),'Rubber Ducks')]"));
        builder.moveToElement(catalog).click().perform();
    }
}
