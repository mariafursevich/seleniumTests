package Task4_Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginCredentialsPage {
        private SelenideElement usernameLocator = $(By.cssSelector("input[name='email']"));
        private  SelenideElement passwordLocator = $(By.cssSelector("input[name='password']"));
        private  SelenideElement loginButtonLocator = $(By.cssSelector("button[value='Login']"));
        private  SelenideElement lostPasswordButtonLocator = $(By.cssSelector(".button-set"));



public void attemptLogin(String username, String password){
    usernameLocator.setValue(username);
    passwordLocator.setValue(password);
    loginButtonLocator.click();
}
public void attemptLostPassword(String username, String password){
    usernameLocator.setValue(username);
    passwordLocator.setValue(password);
    lostPasswordButtonLocator.click();
}
}
