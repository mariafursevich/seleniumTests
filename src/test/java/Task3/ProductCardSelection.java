package Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCardSelection {
    WebDriver driver;
    public void ProductSelection(WebDriver driver){
        driver.findElement(By.xpath("//img[@alt='Yellow Duck']")).click();
        driver.findElement(By.cssSelector("select[name='options[Size]']")).click();
        driver.findElement(By.xpath("//option[@value='Large']")).click();
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
    }
}
