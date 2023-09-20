package PageObjects.Tests;

import WebHooks.WebHooks;
import org.junit.jupiter.api.Test;

import static PageObjects.PageSteps.Authorization.*;
import static PageObjects.PageSteps.OpenUrl.checkUrlPageHref;
import static PageObjects.PageSteps.OpenUrl.openUrl;
import static com.codeborne.selenide.Selenide.sleep;

public class TestIfellowEdujira extends WebHooks {

    @Test
    public void openUrlTest() {
        System.out.println("Test_Open_Url");
        openUrl("https://edujira.ifellow.ru");
        checkUrlPageHref("https://edujira.ifellow.ru");
    };

    @Test
    public void authorizationTest() {
        System.out.println("Test_Authorization");
        openUrl("https://edujira.ifellow.ru");
        authorization();
        profileLogIn();
        authorizationCheck();
    };


}
