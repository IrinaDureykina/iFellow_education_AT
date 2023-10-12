package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.CreatingTaskForm;

import static page_objects.page_elements.BrowseTaskPage.*;
import static page_objects.page_elements.HomePage.*;
import static page_objects.page_steps.InputFieldClickButton.*;
import static util.Config.getProperties;

public class CreatingTask extends CreatingTaskForm {

    @Step("Создаем задачу")
    @Then("Создаем задачу тип: {string} тема: {string}")
    public static void creatingTask(String issueTypeKey, String issueSummaryKey) {
        buttonClick(createBatton, "Создать");
        issueTypeSelect.shouldBe(Condition.visible).doubleClick();
        inputField(issueTypeSelect, getProperties(issueTypeKey), "Тип Задачи", true);
        inputField(issueSummary, getProperties(issueSummaryKey), "Тема", false);
        inputFrame("Описание", "Описание Задачи");
        buttonClick(fixVersionSelector, "Исправить в версиях ");
        priorityselector.doubleClick();
        inputField(priorityselector, "Highest", "Приоритет", true);
        buttonClick(tagsSlectorClik, "Селектор Метки");
        buttonClick(tagsSlector, "Выбор 1 Метки");
        buttonClick(tagsSlectorClik, "Селектор Метки");
        buttonClick(tagsSlector, "Выбор 1 Метки");
        inputFrame("Окружение", "Окружение Задачи");
        buttonClick(affectedVersionsSelector, "Затронуты версии");
        buttonClick(relatedTagsSlector, "Селектор Связанные задачи");
        buttonClick(taskSlectorClik, "Задачи");
        buttonClick(taskSlector, "Выбор '3' Задачи");
        buttonClick(appointMeButton, "Назначить меня");
        buttonClick(CreateIssueButton, "Create Issues Button");
        messageIssueKey.shouldBe(Condition.visible);
        assert messageIssueKey.is(Condition.visible) : "Задача не создана";

    }

    @Then("Переводим созданную задачу по статусам")
    public static void switchingTask() {

        buttonClick(tasksButton, "Задачи");
        buttonClick(reportedByMeButton, "Сообщенные мной");
        buttonClick(taskLink, "Ссылка на задачу");
        buttonClick(inWorkButton, "В работе");
        buttonClick(closeButton, "closeButton");
        buttonClick(businessProcessButton, "Бизнес процесс");
        buttonClick(executedButton, "Исполнено");
        inputFrame("Комментарий", "Комментарий Задачи 'Задача исполнена'");
        buttonClick(executedButtonForm, "Кнопка 'Исполнено' На форме Исполнено");
        buttonClick(closeButton, "closeButton");
        buttonClick(businessProcessButton, "Бизнес процесс");
        buttonClick(confirmedButton, "Подтверждено");
        inputFrame("Комментарий", "Комментарий Задачи 'Задача подтверждена'");
        buttonClick(confirmedButtonForm, "Кнопка 'Подтверждено' На форме Подтверждено");
        buttonClick(closeButton, "closeButton");
        Assertions.assertEquals("Готово", taskStatus.getOwnText(), "Не верный статус задачи");
    }

}
