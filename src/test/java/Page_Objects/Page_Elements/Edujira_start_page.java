package Page_Objects.Page_Elements;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
public class Edujira_start_page {

    public static SelenideElement home_page_button_href = $x("//span[@id='logo']/a[contains(@aria-label,'Перейти на главную страницу')]");


    public static SelenideElement input_Login = $x("//input[@id='login-form-username' and @name='os_username']");

    public static SelenideElement input_Password = $x("//input[@id='login-form-password' and @name='os_password']");

    public static SelenideElement batton_Login = $x("//input[@id='login' and @value='Войти']");


}
