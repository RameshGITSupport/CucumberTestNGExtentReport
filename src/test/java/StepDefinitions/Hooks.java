package StepDefinitions;

import Utilities.PropertiesReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
   Step step;

    @Given("user is on demoQA Home Page")
    public void openBrowser() throws Exception {
        if(PropertiesReader.getValue("browser.name").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
          //  String ss = "C:\\Users\\MOKSHAGNA\\Desktop\\CucumberPOM\\selenium-cucumber-page-object-example-master\\src\\main\\resources\\Drivers\\chromedriver.exe";
          //  System.setProperty("webdriver.chrome.driver", ss);
            driver = new ChromeDriver();

            //       WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--window-size=1440,768", "--disable-gpu");
//        driver = new ChromeDriver(options);
            PropertiesReader propertiesReader = new PropertiesReader();
            driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(PropertiesReader.getValue("url"));
            ExtentCucumberAdapter.addTestStepLog(PropertiesReader.getValue("url"));

        }
    }

    @After
    public void quite() {
        driver.close();
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

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
}
