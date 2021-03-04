package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/autotrader.feature",
		glue= {"stepDefination"},
		plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, strict = false,
		monochrome=true
		)
public class TestRunner 
{
	
}
