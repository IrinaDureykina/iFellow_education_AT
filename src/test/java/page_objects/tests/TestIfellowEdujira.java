package page_objects.tests;

import web_hooks.WebHooks;
import org.junit.jupiter.api.Test;

import static page_objects.page_steps.Authorization.*;
import static page_objects.page_steps.CreatingTask.creatingTask;
import static page_objects.page_steps.CreatingTask.switchingTask;
import static page_objects.page_steps.OpenProject.countIssue;
import static page_objects.page_steps.OpenProject.openProject;
import static page_objects.page_steps.CheckUrl.checkUrlPageHref;
import static page_objects.page_steps.SelectionTask.selectedTaskCheck;
import static page_objects.page_steps.SelectionTask.selectionTask;

public class TestIfellowEdujira extends WebHooks {
    @Test
    public void checkUrlTest() {
        System.out.println("Test check Url");
        checkUrlPageHref("URL");
    }

    @Test
    public void authorizationTest() {
        System.out.println("Test Authorization");
        authorization("login", "password");
        profileLogIn();
        authorizationCheck("login");
    }

    @Test
    public void openProjectTest() {
        System.out.println("Test open Project");
        authorization("login", "password");
        openProject("nameProject");
        countIssue();
    }

    @Test
    public void selectTaskTest() {
        System.out.println("Test Selection Task");
        authorization("login", "password");
        profileLogIn();
        selectionTask("nameTask");
        selectedTaskCheck("statusTask", "affectVersion");
    }

    @Test
    public void creatingTaskTest() {
        System.out.println("Test Сreating Task");
        authorization("login", "password");
        profileLogIn();
        creatingTask();
        switchingTask();
    }
}
