package PageObjects.PageSteps;

import PageObjects.PageElements.EdujiraStartPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class OpenUrl extends EdujiraStartPage {
    public static void openUrl(String url){
        System.out.println("Open: "+ url);
        open(url);
        getWebDriver().manage().window().maximize();
        assert $(By.tagName("body")).shouldBe(Condition.visible).exists() : "На странице отсутствует Body.";
    };

    public static void checkUrlPageHref(String url){
        Assertions.assertTrue(Objects.requireNonNull(homePageHref.shouldBe(Condition.visible).attr("href"))
                        .contains("https://edujira.ifellow.ru/"),
                "Страница не содержит ссылки на главную страницу или она не верна");
        Assertions.assertTrue (WebDriverRunner.url().contains( url ), "URL не совпадает с введенным");
    };
}
