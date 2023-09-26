package web_hooks;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static util.Config.getProperties;



public class WebHooks {

    @BeforeEach
    @Before
    public void beforeClass() {
        System.out.println("Before: Open " + getProperties("URL"));
        open(getProperties("URL"));
        getWebDriver().manage().window().maximize();
        assert $(By.tagName("body")).shouldBe(Condition.visible).exists() : "На странице отсутствует Body.";

    }

    @AfterEach
    @After
    public void afterClass() {
        System.out.println("After: Close web driver");
        WebDriverRunner.closeWebDriver();
    }
}
