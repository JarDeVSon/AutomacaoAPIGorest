package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@regressions",
        glue = "steps",
        monochrome = true,
        plugin = {"html:target/reports/CucumberReports.html", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class RunTest {
}
