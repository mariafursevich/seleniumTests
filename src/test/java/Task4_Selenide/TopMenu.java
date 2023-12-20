package Task4_Selenide;

import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class TopMenu {

    public void navigationInCatalog(){
        SelenideElement catalog = $(By.xpath("//li[@class='category-1']//a[contains(text(),'Rubber Ducks')]"));
        actions().moveToElement(catalog).click().perform();
    }
    public void navigationInSubCategory(){
        SelenideElement catalog = $(By.xpath("//li[@class='category-2']//a[contains(text(),'Subcategory')]"));
        actions().moveToElement(catalog).click().perform();
    }
}
