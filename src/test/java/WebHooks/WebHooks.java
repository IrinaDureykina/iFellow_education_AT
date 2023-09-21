package WebHooks;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterEach
    public void afterClass() {
        System.out.println("After class");
        WebDriverRunner.closeWebDriver();
    }
}
