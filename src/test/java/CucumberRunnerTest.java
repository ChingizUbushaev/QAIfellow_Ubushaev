import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"src/test/java/hooks","src/main/java/steps"})
@Suite//as suit on the JUnitPlatform
@IncludeEngines("cucumber")//which engine will be used when running on junitplatform
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@edujira")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")


public class CucumberRunnerTest {
}
