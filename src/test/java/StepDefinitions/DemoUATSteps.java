package StepDefinitions;

import PageObjects.DemoQAPage;
import PageObjects.DemoUATPage;
import Utilities.PropertiesReader;
import com.aventstack.extentreports.ExtentReports;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoUATSteps {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    DemoUATPage demoUATPage = new DemoUATPage(driver, wait);

    public DemoUATSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Then("verify the title")
    public void verifyTheTitle() {
        demoUATPage.verifyTitle();


    }

    @Given("user navigates to demoUAT Page")
    public void userNavigatesToDemoUATPage() {
        demoUATPage.navigateDemoUATPage();
    }
}
