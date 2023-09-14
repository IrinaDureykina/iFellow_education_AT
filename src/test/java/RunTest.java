import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import iFellow.*;

import java.util.Objects;

public class RunTest {

    @BeforeEach
    public void beforeClass(){
        System.out.println("Before class");
    }

    @AfterEach
    public void afterClass(){
        System.out.println("After class");
    }

    @Test
    public void Test1(){
        System.out.println("1");
        assertEquals("AW", "AW");
    }

    @Test
    public void Test2(){
        System.out.println("2");
        assertEquals("AW", "A@W");
    }

    @Test
    public void fahrenheitTest(){
        System.out.println("Fahrenheit test");
        double result = new BaseConverter(5, 1).convert();
        assertEquals(41.0, result);
    }

    @Test
    public void kelvinTest(){
        System.out.println("Kelvin test");
        double result = new BaseConverter(100, 2).convert();
        assertEquals(373.15, result);
    }

    @Test
    public void mainOpenTest() {
        System.out.println(" Main open Demoqa test");

        open("https://demoqa.com/automation-practice-form");

        String pageURL = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(pageURL.contains("https://demoqa.com/automation-practice-form"), "Не верный URL");
    }

}
