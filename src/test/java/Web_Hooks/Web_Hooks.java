package Web_Hooks;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class Web_Hooks {

    @BeforeAll
    public static void before_Class() {
        System.out.println("Before class");
    }

    @AfterEach
    public void after_Class() {
        System.out.println("After class");
        WebDriverRunner.closeWebDriver();
    }
}
