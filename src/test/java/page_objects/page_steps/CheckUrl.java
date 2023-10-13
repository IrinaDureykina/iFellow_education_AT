package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.EdujiraStartPage;

import java.util.Objects;

import static util.Config.getProperties;

public class CheckUrl extends EdujiraStartPage {
    @Step("Проверяем {url} и наличие ссылки на главную страницу")
    @Then("Проверяем {string} и наличие ссылки на главную страницу")
    public static void checkUrlPageHref(String url) {

        Assertions.assertTrue(Objects.requireNonNull(homePageHref.shouldBe(Condition.visible).attr("href")).contains(getProperties(url)), "Страница не содержит ссылки на главную страницу или она не верна");

        Assertions.assertTrue(WebDriverRunner.url().contains(getProperties(url)), "URL не совпадает с введенным");
    }
}
