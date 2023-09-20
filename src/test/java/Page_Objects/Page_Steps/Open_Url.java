package Page_Objects.Page_Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static Page_Objects.Page_Elements.Edujira_Start_Page.title_Page;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Open_Url {
    public static void open_Url(String url){
        System.out.println("Open: "+ url);
        open(url);
        getWebDriver().manage().window().maximize();
        assert $(By.tagName("body")).shouldBe(Condition.visible).exists() : "Body нет на странице.";
    };

    public static void check_Url_Title_Page(String url){

        Assertions.assertTrue(title_Page.shouldBe(Condition.hidden).getOwnText().contains("System Dashboard - Jira"),
                "Заголовок страницы не содержит 'System Dashboard - Jira'");

        Assertions.assertTrue (WebDriverRunner.url().contains( url ), "Не верный URL");
    };
}
