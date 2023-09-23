package PageObjects.Tests;

import WebHooks.WebHooks;
import org.junit.jupiter.api.Test;

import static PageObjects.PageSteps.Authorization.*;
import static PageObjects.PageSteps.CreatingTask.creatingTask;
import static PageObjects.PageSteps.CreatingTask.switchingTask;
import static PageObjects.PageSteps.OpenProject.countIssue;
import static PageObjects.PageSteps.OpenProject.openProject;
import static PageObjects.PageSteps.OpenUrl.checkUrlPageHref;
import static PageObjects.PageSteps.OpenUrl.openUrl;
import static PageObjects.PageSteps.SelectionTask.selectedTaskCheck;
import static PageObjects.PageSteps.SelectionTask.selectionTask;

public class TestIfellowEdujira extends WebHooks {

    final String URL = "https://edujira.ifellow.ru";

    @Test
    public void openUrlTest() {
        System.out.println("Test Open Url");
        openUrl(URL);
        checkUrlPageHref(URL);
    }

    @Test
    public void authorizationTest() {
        System.out.println("Test Authorization");
        openUrl(URL);
        authorization();
        profileLogIn();
        authorizationCheck();
    }

    @Test
    public void openProjectTest() {
        System.out.println("Test open Project");
        openUrl(URL);
        authorization();
        openProject();
        countIssue();
    }

    @Test
    public void selectTaskTest() {
        System.out.println("Test Selection Task");
        openUrl(URL);
        authorization();
        profileLogIn();
        selectionTask("TestSelenium");
        selectedTaskCheck();
    }

    @Test
    public void creatingTaskTest() {
        System.out.println("Test Сreating Task");
        openUrl(URL);
        authorization();
        profileLogIn();
        creatingTask();
        switchingTask();
    }
}
