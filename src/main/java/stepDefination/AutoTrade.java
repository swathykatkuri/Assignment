package stepDefination;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cucumber.listener.Reporter;
import PageObject.AdvanceSearch;
import PageObject.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.DriverFactory;
import utility.Utility;

public class AutoTrade {

	public WebDriver driver;
	HomePage homepage;
	AdvanceSearch advanceSearch;

	@Before
	public void setUp() {
		
		driver = DriverFactory.get_driver_instance();
		homepage = new HomePage(driver);
		advanceSearch = new AdvanceSearch(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		
		Reporter.loadXMLConfig(new File("./config/extent-config.xml"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.141.59");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
		driver.quit();
	}

	@Given("^user navigates to the Autotrade application$")
	public void user_is_on_the_application_home_page() throws Throwable {
		driver.get(Utility.getProperty("url"));

	}

	@When("^Verifying the Links,buttons and Dropdowns$")
	public void verfiy_links() throws Throwable {
		Reporter.addStepLog("Verifying the links,buttons and dropdowns");
		homepage.Verify_link();
	}

	@Then("^Clicks on the Advance Search$")
	public void clicks_advance_search() throws Throwable {
		Reporter.addStepLog("Clicked on the Advance search Link");
		homepage.click_AdvanceSearch_link();
	}

	@Then("^Searching the makes cars$")
	public void Search_Car() throws Throwable {
		Reporter.addStepLog("Entered the search criteria and clicked on search");
		advanceSearch.searchcar("30004", "BMW");

		advanceSearch.verfiyingHeading();
		String result = advanceSearch.countofResult();
		Reporter.addStepLog("Totally "+result);
	}

}
