package PageObjects.PageSteps;

import PageObjects.PageElements.HomePage;
import org.junit.jupiter.api.Assertions;

import static PageObjects.PageSteps.InputFieldClickButton.buttonClick;
import static PageObjects.PageSteps.InputFieldClickButton.inputField;

public class SelectionTask extends HomePage {
    public static void selectionTask() {
        inputField(searchInput, "TestSelenium", "Поиск", true);
        buttonClick(taskLink, "issueLink");
    };

    public static void searchTaskCheck() {
        Assertions.assertEquals("Сделать", taskStatus.getOwnText(), "Не верный статус задачи");
        Assertions.assertTrue (taskVersions.getOwnText().contains("Version 2.0")
                , "Не верная привязка задачи к затронутой версии");
    };
}
