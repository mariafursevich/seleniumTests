package Task4_Selenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;
@Listeners(ScreenshotListener.class)
public class LoginPageTests extends TestBase {
    @Test
    @Feature("Login") @Story("US-1")  @Description("Login with valid credentials")
    public void validCredentials()  {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLogin("test1@test.com", "1234567");
        $(By.cssSelector(".notice.success")).shouldBe(visible);
        tearDown();
    }
    @Test
    @Feature("Login") @Story("US-1")  @Description("Verify that error is shown if user entered invalid credentials")
    public void invalidCredentials()  {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLogin("test1@test.com", "1234");
        $(By.cssSelector(".notice.errors")).shouldBe(visible);
        tearDown();
    }
    @Test
    @Feature("Login") @Story("US-1") @Description("Verify that inf message is shown after user clicked on Reset the password")
    public void lostPassword()  {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLostPassword("test1@test.com", "");
        $(By.cssSelector(".notice.success")).shouldHave(text("A new password has been sent to your email address."));
        tearDown();
    }
}
