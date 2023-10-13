import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/edujiraIfellowRu.feature",
        glue = {"page_objects/page_steps", "web_hooks"},
        snippets = CucumberOptions.SnippetType.UNDERSCORE,
        plugin = {"pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json",
                "html:target/test-output"})

public class RunnerTest {
}
