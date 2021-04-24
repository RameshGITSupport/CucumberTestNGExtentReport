package StepDefinitions;

import PageObjects.DemoQAPage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQASteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    DemoQAPage demoQAPage = new DemoQAPage(driver, wait);

    public DemoQASteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }
    @Given("^user navigates to radio button page$")
    public void user_navigates_to_radio_button_page() {
      //  DemoQAPage demoQAPage = new DemoQAPage(driver, wait);
        demoQAPage.navigateTORadioPage();
    }

    @When("^user click on Yes radio$")
    public void user_click_on_Yes_radio() {
      //  DemoQAPage demoQAPage = new DemoQAPage(driver, wait);
        demoQAPage.clickRadioButton();

    }

    @Then("^validate yes radio is selected$")
    public void validate_yes_radio_is_selected() {

        demoQAPage.validteYesRadioSelected();

    }



}