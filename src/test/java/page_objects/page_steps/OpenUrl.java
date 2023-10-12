package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.Before;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static util.Config.getProperties;

public class OpenUrl {

    @Before(order = 2)
    public void openUrlGetWebDriver() {

        String openUrl = getProperties("URL");
        step("Открываем сайт: " +openUrl, () -> {
            open(openUrl);
            getWebDriver().manage().window().maximize();
            assert $(By.tagName("body")).shouldBe(Condition.visible).exists() : "На странице отсутствует Body.";
        });
    }
}
