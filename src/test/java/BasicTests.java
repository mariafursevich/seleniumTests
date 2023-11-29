import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasicTests {
    @Test
    public void OpeningPageTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.get(10).click();
        WebElement textDragDrop = (new WebDriverWait(driver, Duration.ofSeconds(5))).
                until(ExpectedConditions.presenceOfElementLocated(By.className("example")));
        Assert.assertTrue(textDragDrop.isDisplayed());
        driver.quit();
    }
}
