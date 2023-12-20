package Task4_Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class CheckoutPageTests extends TestBase {
    @Test
    public void productInBasket() throws InterruptedException {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLogin("test@test.com", "1234567");
        SelenideElement catalog = $(By.xpath("//li[@class='category-1']//a[contains(text(),'Rubber Ducks')]"));
        actions().moveToElement(catalog).click().perform();
        new CatalogPage().AddingYellowDuckToCard();
        Thread.sleep(2000);
        $(By.xpath("//a[normalize-space()='Checkout »']")).click();
        $(By.xpath("//h2[normalize-space()='Order Summary']")).shouldHave(text("Order Summary"));
        tearDown();
    }
}
