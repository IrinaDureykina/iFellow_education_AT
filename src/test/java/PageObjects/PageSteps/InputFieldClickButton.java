package PageObjects.PageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static PageObjects.PageElements.CreatingTaskForm.frameInputField;
import static PageObjects.PageElements.CreatingTaskForm.returnFrameField;
import static com.codeborne.selenide.Selenide.switchTo;

public class InputFieldClickButton {

    public static void inputField(SelenideElement xpath, String valueField, String fieldName, boolean key) {

        xpath.shouldBe(Condition.visible).sendKeys(valueField);
        Assertions.assertEquals(valueField, xpath.getValue(), "В поле " + fieldName + " Введено неверное значение.");

        if (key) {
            xpath.pressEnter();
        }
    }

    public static void buttonClick(SelenideElement xpath, String buttonName) {
        xpath.shouldBe(Condition.visible);
        assert xpath.is(Condition.visible) : buttonName + " не отображается на странице или не кликабельна.";
        xpath.shouldBe(Condition.enabled).click();
    }

    public static void inputFrame(String name, String valueText) {
        switchTo().frame(frameInputField(name));
        returnFrameField.shouldBe(Condition.enabled).setValue(valueText);
        Assertions.assertEquals(valueText, returnFrameField.getOwnText(), "В окно ввода " + name + " Введено неверное значение.");
        switchTo().defaultContent();
    }
}
