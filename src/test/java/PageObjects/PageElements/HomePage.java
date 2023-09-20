package PageObjects.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public static SelenideElement nameUser = $x("//dt[contains(text(),'Полное имя:')]//following-sibling::dd");

    public static SelenideElement profileBatton = $x("//a[@id='header-details-user-fullname' and contains(@title, 'Пользовательский профиль для')]");

    public static SelenideElement profileLink = $x("//li/a[contains(text(),'Профиль')]");

    public static SelenideElement allIssues = $x("//span[contains(text(),'Задачи')]/ancestor::a[@class='aui-nav-item ']");
    public static SelenideElement goToProjectButton = $x("//a[contains(text(),'Проекты') and @aria-controls = 'browse_link-content']");

    public static SelenideElement goToProjectLink = $x("//a[contains(text(),'Test (TEST)')]");

    public static SelenideElement countIssues = $x("//div[@class='pager']/div[@class='showing']/span[contains(text(),'1 из')]");
}
