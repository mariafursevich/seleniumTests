package Task4_Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

        protected final String baseUrl = "https://litecart.stqa.ru/en/";
        URL hubUrl;

    {
        try {
            hubUrl = new URL("http://192.168.100.81:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeTest
        protected void setup()  {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setPlatform(Platform.WINDOWS);
            caps.setBrowserName(CHROME);
            //caps.setVersion("95.0");

            WebDriver driver = new RemoteWebDriver(hubUrl, caps);
            WebDriverRunner.setWebDriver(driver);


            //WebDriver driver = new RemoteWebDriver(new URL(“http://192.168.100.81:4444/wd/hub”), caps);
            //Configuration.browser = System.getProperty("browser", "chrome");
            //Configuration.browserSize = "1920*1080";
            open(baseUrl);
        }

        @AfterTest
        protected void tearDown(){
            WebDriverRunner.closeWebDriver();
        }



}
