package page_objects.page_steps;

import page_objects.page_elements.HomePage;
import org.junit.jupiter.api.Assertions;

import static page_objects.page_elements.BrowseTaskPage.taskStatus;
import static page_objects.page_elements.BrowseTaskPage.taskVersions;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;

public class SelectionTask extends HomePage {
    public static void selectionTask(String nameTask) {
        inputField(searchInput, nameTask, "Поиск", true);
        buttonClick(taskLink, "issueLink");
    }

    public static void selectedTaskCheck() {
        Assertions.assertEquals("Сделать", taskStatus.getOwnText(), "Не верный статус задачи");
        Assertions.assertTrue(taskVersions.getOwnText().contains("Version 2.0")
                , "Не верная привязка задачи к затронутой версии");
    }
}
