package PageObjects.Tests;

import WebHooks.WebHooks;
import org.junit.jupiter.api.Test;

import static PageObjects.PageSteps.Authorization.*;
import static PageObjects.PageSteps.OpenProject.countIssue;
import static PageObjects.PageSteps.OpenProject.openProject;
import static PageObjects.PageSteps.OpenUrl.checkUrlPageHref;
import static PageObjects.PageSteps.OpenUrl.openUrl;
import static PageObjects.PageSteps.SelectionTask.searchTaskCheck;
import static PageObjects.PageSteps.SelectionTask.selectionTask;

public class TestIfellowEdujira extends WebHooks {

    String url = "https://edujira.ifellow.ru";
    @Test
    public void openUrlTest() {
        System.out.println("Test Open Url");
        openUrl(url);
        checkUrlPageHref(url);
    };

    @Test
    public void authorizationTest() {
        System.out.println("Test Authorization");
        openUrl(url);
        authorization();
        profileLogIn();
        authorizationCheck();
    };

    @Test
    public void openProjectTest() {
        System.out.println("Test open Project");
        openUrl(url);
        authorization();
        openProject();
        countIssue();
    };

    @Test
    public void selectTaskTest() {
        System.out.println("Test Selection Task");
        openUrl(url);
        authorization();
        profileLogIn();
        selectionTask();
        searchTaskCheck();


    };

}
