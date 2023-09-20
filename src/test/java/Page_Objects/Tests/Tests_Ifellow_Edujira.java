package Page_Objects.Tests;

import Web_Hooks.Web_Hooks;
import org.junit.jupiter.api.Test;

import static Page_Objects.Page_Steps.Open_Url.check_Url_Title_Page;
import static Page_Objects.Page_Steps.Open_Url.open_Url;

public class Tests_Ifellow_Edujira extends Web_Hooks {

    @Test
    public void Test_Open_Url() {
        System.out.println("Test_Open_Url");
        open_Url("https://edujira.ifellow.ru");
        check_Url_Title_Page("https://edujira.ifellow.ru");
    };
}
