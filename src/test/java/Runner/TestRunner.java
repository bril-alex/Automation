package Runner;

import installation.BaseClass;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber_certificate",//path to feature files
        glue = "certificate_steps",//package path
        tags = "@CERTIFICATE",//list feature files for run
        dryRun = false,
        publish = true
)
public class TestRunner {
    @BeforeClass
    public static void create() {
        BaseClass.createDriver();
    }

    @AfterClass
    public static void end() throws InterruptedException {
        BaseClass.closeBrowser();
    }
}
