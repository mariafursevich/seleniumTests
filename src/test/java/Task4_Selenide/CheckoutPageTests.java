package Task4_Selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
@Listeners(ScreenshotListener.class)
public class CheckoutPageTests extends TestBase {
    @Test
    @Feature("Basket") @Story("US-2") @Description("Verify that selected products are shown in basket")
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
