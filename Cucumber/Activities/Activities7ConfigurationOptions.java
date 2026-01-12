package stepDefinition;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "stepDefinitions"
)
@ConfigurationParameter(
        key = Constants.FILTER_TAGS_PROPERTY_NAME,
        value = "@activity3"
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, " +
                "html:target/Reports/HTML_Report.html, " +
                "junit:target/Reports/XML_Report.xml, " +
                "usage:target/Reports/Usage_Report.txt"
)
public class Activities7ConfigurationOptions {
}
