package page_objects.page_steps;

import page_objects.page_elements.EdujiraStartPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;

import static page_objects.page_elements.HomePage.*;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;

public class Authorization extends EdujiraStartPage {

    public static void authorization() {
        inputField(inputLogin, "AT5", "Имя пользователя", false);
        inputField(inputPassword, "Qwerty123", "Пароль", false);
        buttonClick(battonLogin, "Кнопка 'Войти'");
    }

    public static void profileLogIn() {
        buttonClick(profileBatton, "Кнопка пользовательский профиль");
        buttonClick(profileLink, "Ссылка профиль");
    }

    public static void authorizationCheck() {
        Assertions.assertEquals(nameUser.shouldBe(Condition.visible).getOwnText(), "AT5", "Не авторизованы");
    }
}
