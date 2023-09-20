package Page_Objects.Tests;

import Web_Hooks.Web_Hooks;
import org.junit.jupiter.api.Test;

import static Page_Objects.Page_Steps.Open_url.check_url_title_page;
import static Page_Objects.Page_Steps.Open_url.open_url;

public class Tests_efellow_edujira extends Web_Hooks {

    @Test
    public void Test_Open_Url() {
        System.out.println("Test_Open_Url");
        open_url("https://edujira.ifellow.ru");
        check_url_title_page("https://edujira.ifellow.ru");
    };
}
