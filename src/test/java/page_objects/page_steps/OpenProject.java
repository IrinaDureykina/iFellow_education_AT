package page_objects.page_steps;

import io.cucumber.java.en.Then;
import page_objects.page_elements.HomePage;
import com.codeborne.selenide.Condition;

import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static util.Config.getProperties;

public class OpenProject extends HomePage {

    @Then("Заходим в проект {string}")
    public static void openProject(String nameTaskKey) {

        buttonClick(openProjectButton, "Project Button");
        buttonClick(openProjectLink(getProperties(nameTaskKey)), "Project Link");
        buttonClick(allIssues, "Задачи");
    }

    @Then("Получаем количество задач в проекте")
    public static String countIssue() {
        assert countIssues.is(Condition.visible) : "Количество задач не отображается.";
        String countIssuesText = countIssues.getOwnText();

        String newCountIssues = countIssuesText.replace("1 из ", "");
        assert !newCountIssues.isEmpty() : "Нет значения в количестве задач.";

        System.out.println("Количество задач в проекте: " + newCountIssues);
        return newCountIssues;
    }
}
