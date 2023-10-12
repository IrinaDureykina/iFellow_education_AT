package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.EdujiraStartPage;

import static io.qameta.allure.Allure.step;
import static page_objects.page_elements.HomePage.*;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static util.Config.getProperties;

public class Authorization extends EdujiraStartPage {

    @When("Вводим {string} вводим {string} и нажимаем Войти")
    public static void authorization(String loginKey, String passwordKey) {

        String login = getProperties(loginKey);
        String password = getProperties(passwordKey);
        step("Вводим имя прользователя: " + login + " вводим пароль: " + password + " и нажимаем Войти", () -> {
            inputField(inputLogin, login, "Имя пользователя", false);
            inputField(inputPassword, password, "Пароль", false);
            buttonClick(battonLogin, "Кнопка 'Войти'");
        });

    }

    @Step("Заходим в профиль")
    @Then("Заходим в профиль")
    public static void profileLogIn() {
        buttonClick(profileBatton, "Кнопка пользовательский профиль");
        buttonClick(profileLink, "Ссылка профиль");
    }

    @Step("Сверяем имя профиля с введенным {string}")
    @Then("Сверяем имя профиля с введенным {string}")
    public static void authorizationCheck(String loginKey) {
        Assertions.assertEquals(nameUser.shouldBe(Condition.visible).getOwnText(), getProperties(loginKey), "Не авторизованы");
    }
}
