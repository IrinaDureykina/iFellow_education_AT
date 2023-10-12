package web_hooks;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class WebHooks {
    @Before(order = 1)
    public static void allureSelenideListener() {
        String listenerName = "Allureselenide";
        if(SelenideLogger.hasListener(listenerName)) {
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false)));
        }
    }

    @Attachment(value = "Test screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @AfterStep
    public void screenShotIsFailedStep(Scenario scenario) {
        if (scenario.isFailed()){
            saveScreenshot();
        }
    }

    @After
    public void afterTest() {
        saveScreenshot();
        WebDriverRunner.closeWebDriver();
    }
}
