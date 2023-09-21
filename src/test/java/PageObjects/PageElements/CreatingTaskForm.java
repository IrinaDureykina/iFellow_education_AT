package PageObjects.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreatingTaskForm {

    public static SelenideElement issueTypeSelect = $x("//div[@id='issuetype-single-select']/input");

    public static SelenideElement issueSummary = $x(" //input[@id='summary' and @name='summary']");


    public static SelenideElement CreateIssueButton = $x(" //input[@id='create-issue-submit' and @value='Создать']");

    public static SelenideElement returnIssueKey = $x(" //div[contains(text(),'Запрос ')]/a");
}
