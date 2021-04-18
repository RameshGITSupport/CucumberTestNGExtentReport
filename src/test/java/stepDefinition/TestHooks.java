package stepDefinition;


import Utility.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class TestHooks {


	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Started execution for the scenario : " + scenario.getName());

	}
	
	@Before("@TestCase2")
	public void beforeTestCase2(Scenario scenario) {		

		System.out.println("=========================================");
		System.out.println("Executing before Testcase2");
		System.out.println("=========================================");
		
	}
	
	@After
	public void AfterScenario(Scenario scenario) {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}


	@After
	public void quite() {

		BasePage.driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		//validate if scenario has failed
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image");
		}
	}
}
