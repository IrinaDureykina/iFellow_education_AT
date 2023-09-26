package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.EdujiraStartPage;

import static page_objects.page_elements.HomePage.*;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static util.Config.getProperties;

public class Authorization extends EdujiraStartPage {

    @When("Вводим {string} вводим {string} и нажимаем Войти")
    public static void authorization(String loginKey, String passwordKey) {
        inputField(inputLogin, getProperties(loginKey), "Имя пользователя", false);
        inputField(inputPassword, getProperties(passwordKey), "Пароль", false);
        buttonClick(battonLogin, "Кнопка 'Войти'");
    }

    @Then("Заходим в профиль")
    public static void profileLogIn() {
        buttonClick(profileBatton, "Кнопка пользовательский профиль");
        buttonClick(profileLink, "Ссылка профиль");
    }

    @Then("Сверяем имя профиля с введенным {string}")
    public static void authorizationCheck(String loginKey) {
        Assertions.assertEquals(nameUser.shouldBe(Condition.visible).getOwnText(), getProperties(loginKey), "Не авторизованы");
    }
}
