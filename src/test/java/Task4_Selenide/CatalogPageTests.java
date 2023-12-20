package Task4_Selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPageTests extends TestBase {
  @Test
    public void productOnSale(){
        setup();
        new TopMenu().navigationInCatalog();
        $(By.xpath("//div[@title='On Sale']")).shouldBe(visible);
        $(By.xpath("//img[@alt='Yellow Duck']")).shouldBe(visible);;
        tearDown();
    }
    @Test
    public void productOnSaleFullCard(){
        setup();
        new TopMenu().navigationInCatalog();
        $(By.xpath("//img[@alt='Yellow Duck']")).click();
        $(By.xpath("//img[@title='Yellow Duck']")).shouldBe(visible);
        tearDown();
    }
    @Test
    public void productOnSalePrice(){
        setup();
        new TopMenu().navigationInCatalog();
        $(By.xpath("//img[@alt='Yellow Duck']")).click();
        $(By.xpath("//strong[@class='campaign-price']")).shouldHave(text("$18"));
        tearDown();
    }
}
