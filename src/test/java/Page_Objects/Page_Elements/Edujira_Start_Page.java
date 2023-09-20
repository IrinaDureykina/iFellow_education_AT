package Page_Objects.Page_Elements;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
public class Edujira_Start_Page {

    public static SelenideElement title_Page = $x("//head/title");

    public static SelenideElement input_Login = $x("//input[@id='login-form-username' and @name='os_username']");

    public static SelenideElement input_Password = $x("//input[@id='login-form-password' and @name='os_password']");

    public static SelenideElement batton_Login = $x("//input[@id='login' and @value='Войти']");


}
