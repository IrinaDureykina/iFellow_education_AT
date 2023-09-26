package page_objects.page_steps;

import page_objects.page_elements.HomePage;
import com.codeborne.selenide.Condition;

import static page_objects.page_steps.InputFieldClickButton.buttonClick;

public class OpenProject extends HomePage {

    public static void openProject() {

        buttonClick(openProjectButton, "Project Button");
        buttonClick(openProjectLink, "Project Link");
        buttonClick(allIssues, "Задачи");


    }

    public static String countIssue() {
        assert countIssues.is(Condition.visible) : "Количество задач не отображается.";
        String countIssuesText = countIssues.getOwnText();

        String newCountIssues = countIssuesText.replace("1 из ", "");
        assert !newCountIssues.isEmpty() : "Нет значения в количестве задач.";

        System.out.println("Количество задач в проекте: " + newCountIssues);
        return newCountIssues;
    }
}
