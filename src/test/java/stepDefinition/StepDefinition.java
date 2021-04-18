package stepDefinition;
import PageObjects.DemoQAPage;
import Utility.BasePage;
import Utility.CommonFunctions;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinition {
    WebDriver driver=BasePage.driver;
    DemoQAPage demoQAPage = new DemoQAPage(driver);
    BasePage basePage = new BasePage();
    CommonFunctions commonFunctions = new CommonFunctions();

    @Given("^user is on demoQA Home Page$")
    public void user_is_on_demoQA_Home_Page() throws InterruptedException {

        basePage.OpenBrowser(BasePage.getProperty("browser.name"));

    }

    @Given("^user navigates to textbox page$")
    public void user_navigates_to_textbox_page() {
    demoQAPage.navigateToTextBoxPage();

    }

    @When("^user enters full name and email$")
    public void user_enters_full_name_and_email() {
    demoQAPage.userEnterEmail();

    }

    @And("^user enters current address and permanent address$")
    public void user_enters_current_address_and_permanent_address() {
       demoQAPage.userEnterCurrentAndPermanentsAddress();

    }

    @When("^user clicks on submit button$")
    public void user_clicks_on_submit_button() {
    demoQAPage.clickSubmitButton();

    }

    @Then("^validate correct name is displayed$")
    public void validate_correct_name_is_displayed() {
    demoQAPage.vallidateCorrectName();
    }


    @Given("^user navigates to radio button page$")
    public void user_navigates_to_radio_button_page() {
        demoQAPage.navigateTORadioPage();
     }

    @When("^user click on Yes radio$")
    public void user_click_on_Yes_radio() {
        demoQAPage.clickRadioButton();

    }

    @Then("^validate yes radio is selected$")
    public void validate_yes_radio_is_selected() {
        demoQAPage.validteYesRadioSelected();

    }



}
