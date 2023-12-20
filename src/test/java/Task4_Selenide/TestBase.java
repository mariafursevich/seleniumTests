package Task4_Selenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

        protected final String baseUrl = "https://litecart.stqa.ru/en/";

        @BeforeTest
        protected void setup() {
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserSize = "1920*1080";
            open(baseUrl);
        }

        @AfterTest
        protected void tearDown(){
            closeWebDriver();
        }



}
