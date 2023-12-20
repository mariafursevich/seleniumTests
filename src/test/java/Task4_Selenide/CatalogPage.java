package Task4_Selenide;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    public void AddingYellowDuckToCard(){
        $(By.xpath("//img[@alt='Yellow Duck']")).click();
        $(By.cssSelector("select[name='options[Size]']")).click();
        $(By.xpath("//option[@value='Large']")).click();
        $(By.xpath("//button[@name='add_cart_product']")).click();
    }
    public void AddingRedDuckToCard(){
        $(By.xpath("//img[@alt='Red Duck']")).click();
        $(By.cssSelector("select[name='options[Size]']")).click();
        $(By.xpath("//option[@value='Large']")).click();
        $(By.xpath("//button[@name='add_cart_product']")).click();
    }
}
