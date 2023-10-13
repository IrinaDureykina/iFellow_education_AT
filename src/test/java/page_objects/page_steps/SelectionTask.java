package page_objects.page_steps;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.HomePage;

import static io.qameta.allure.Allure.step;
import static page_objects.page_elements.BrowseTaskPage.taskStatus;
import static page_objects.page_elements.BrowseTaskPage.taskVersions;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static util.Config.getProperties;

public class SelectionTask extends HomePage {

    @Then("Производим поиск задачи: {string}")
    public static void selectionTask(String nameTaskKey) {

        String nameTask = getProperties(nameTaskKey);
        step("Производим поиск задачи по имени: "+nameTask, () -> {
            inputField(searchInput, nameTask, "Поиск", true);
            buttonClick(taskLink, "issueLink");
        });
    }

    @Then("Сверяем {string} и привязку {string}")
    public static void selectedTaskCheck(String statusTaskKey, String affectVersionKey) {

        String statusTask = getProperties(statusTaskKey);
        String affectVersion = getProperties(affectVersionKey);
        step("Сверяем статус задачи с: "+statusTask+" и Затронуты версии: " +affectVersion, () -> {
            Assertions.assertEquals(statusTask, taskStatus.getOwnText(), "Не верный статус задачи");
            Assertions.assertTrue(taskVersions.getOwnText().contains(getProperties(affectVersionKey)), "Не верная привязка задачи к затронутой версии");
        });
    }
}
