package Task4_Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageTests extends TestBase {
    @Test
    public void validCredentials() {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLogin("test@test.com", "1234567");
        $(By.cssSelector(".notice.success")).shouldBe(visible);
        tearDown();
    }
    @Test
    public void invalidCredentials() {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLogin("test@test.com", "1234");
        $(By.cssSelector(".notice.errors")).shouldBe(visible);
        tearDown();
    }
    @Test
    public void lostPassword() {
        setup();
        LoginCredentialsPage loginCredentialsPage = new LoginCredentialsPage();
        loginCredentialsPage.attemptLostPassword("test@test.com", "");
        $(By.cssSelector(".notice.success")).shouldHave(text("A new password has been sent to your email address."));
        tearDown();
    }
}
