package Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Certificate {
    WebDriver driver;
    public Certificate (WebDriver driver){
        this.driver=driver;
    }
    public void acceptCertificate(){
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }
}
