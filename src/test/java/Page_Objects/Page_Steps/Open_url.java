package Page_Objects.Page_Steps;

import Page_Objects.Page_Elements.Edujira_start_page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Open_url extends Edujira_start_page {
    public static void open_url(String url){
        System.out.println("Open: "+ url);
        open(url);
        getWebDriver().manage().window().maximize();
        assert $(By.tagName("body")).shouldBe(Condition.visible).exists() : "На странице отсутствует Body.";
    };

    public static void check_url_title_page(String url){
        Assertions.assertTrue(Objects.requireNonNull(home_page_button_href.shouldBe(Condition.visible).attr("href"))
                        .contains("https://edujira.ifellow.ru/"),
                "Страница не содержит ссылки на главную страницу или она не верна");
        Assertions.assertTrue (WebDriverRunner.url().contains( url ), "URL не совпадает с введенным");
    };
}
