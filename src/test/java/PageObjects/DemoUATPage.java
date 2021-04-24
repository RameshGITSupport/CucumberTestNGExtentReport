package PageObjects;

import StepDefinitions.Hooks;
import Utilities.BaseClass;
import Utilities.CommonFunctions;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoUATPage extends BaseClass {
    WebDriver driver= Hooks.driver;
    WebDriverWait wait;
    public DemoUATPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    CommonFunctions commonFunctions = new CommonFunctions(driver,wait);
    //public By radioButton = By.xpath("//label[text()='Yes']");



    public void navigateDemoUATPage(){
        commonFunctions.navigate("http://demo.guru99.com/test/newtours/");
    }
    public void verifyTitle(){
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = commonFunctions.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        ExtentCucumberAdapter.addTestStepLog("Actual Title is:"+actualTitle+" Expected Title is:"+expectedTitle);
    }
}
