package PageObjects.PageSteps;

import PageObjects.PageElements.CreatingTaskForm;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import static PageObjects.PageElements.BrowseTaskPage.*;
import static PageObjects.PageElements.HomePage.*;
import static PageObjects.PageSteps.InputFieldClickButton.*;

public class CreatingTask extends CreatingTaskForm {
    public static void creatingTask(){
        String inputTheme = "Тема Ошибки";
        buttonClick(createBatton, "Create Button");
        issueTypeSelect.shouldBe(Condition.visible).doubleClick();
        inputField(issueTypeSelect, "Ошибка", "Тип Задачи", true );
        inputField(issueSummary, inputTheme, "Тема", false);


        buttonClick(CreateIssueButton, "Create Issues Button");
        messageIssueKey.shouldBe(Condition.visible);
        assert messageIssueKey.is(Condition.visible) : "Задача не создана";

    };

    public static void switchingTask(){

        buttonClick(tasksButton,  "Задачи");
        buttonClick(reportedByMeButton, "Сообщенные мной");
        buttonClick(taskLink, "Ссылка на задачу");
        buttonClick(inWorkButton,"В работе");
        buttonClick(closeButton, "closeButton");
        buttonClick(businessProcessButton, "Бизнес процесс");
        buttonClick(executedButton, "Исполнено");
        buttonClick(executedButtonForm, "Исполнено На форме Исполнено");
        buttonClick(closeButton, "closeButton");
        buttonClick(businessProcessButton, "Бизнес процесс");
        buttonClick(confirmedButton, "Подтверждено");
        buttonClick(confirmedButtonForm, "Подтверждено На форме Подтверждено");
        buttonClick(closeButton, "closeButton");
        Assertions.assertEquals("Готово", taskStatus.getOwnText(), "Не верный статус задачи");
    };
}
