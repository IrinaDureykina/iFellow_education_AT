package PageObjects.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public static SelenideElement nameUser = $x("//dt[contains(text(),'Полное имя:')]//following-sibling::dd");

    public static SelenideElement profileBatton = $x("//a[@id='header-details-user-fullname' and contains(@title, 'Пользовательский профиль для')]");

    public static SelenideElement profileLink = $x("//li/a[contains(text(),'Профиль')]");

    public static SelenideElement allIssues = $x("//span[contains(text(),'Задачи')]/ancestor::a[@class='aui-nav-item ']");

    public static SelenideElement openProjectButton = $x("//a[contains(text(),'Проекты') and @aria-controls = 'browse_link-content']");

    public static SelenideElement openProjectLink = $x("//a[contains(text(),'Test (TEST)')]");

    public static SelenideElement countIssues = $x("//div[@class='pager']/div[@class='showing']/span[contains(text(),'1 из')]");

    public static SelenideElement searchInput = $x("//input[@id='quickSearchInput']");

    public static SelenideElement taskLink = $x("//a[@id='key-val']");

    public static SelenideElement taskStatus = $x("//span[@id='status-val']//following-sibling::span");

    public static SelenideElement taskVersions = $x("//span[@id='versions-val' and @title='Нажмите, чтобы изменить']");
}
