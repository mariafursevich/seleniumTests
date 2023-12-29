package Task4_Selenide;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ScreenshotListener implements ITestListener {
Logger log = Logger.getLogger(ScreenshotListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        File screenshot = Selenide.screenshot(OutputType.FILE);
        try {
            Allure.addAttachment(result.getMethod().getMethodName() + "test screenshot", new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            log.warn("Couldn't take screenshot");
        }
    }
}
