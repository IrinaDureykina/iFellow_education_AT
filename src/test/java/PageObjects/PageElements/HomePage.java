package PageObjects.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public static SelenideElement nameUser = $x("//dt[contains(text(),'Полное имя:')]//following-sibling::dd");

    public static SelenideElement profileBatton = $x("//a[@id='header-details-user-fullname' and contains(@title, 'Пользовательский профиль для')]");

    public static SelenideElement profileLink = $x("//li/a[contains(text(),'Профиль')]");
}
