package PageObjects;

import StepDefinitions.Hooks;
import Utilities.BaseClass;
import Utilities.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DemoQAPage extends BaseClass {
    WebDriver driver=Hooks.driver;
    WebDriverWait wait;
      public DemoQAPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

   CommonFunctions commonFunctions = new CommonFunctions(driver,wait);
    //public By radioButton = By.xpath("//label[text()='Yes']");


    @FindBy(how= How.XPATH,using="//label[text()='Yes']")
    public WebElement radioButton;


    public void navigateTORadioPage(){
        driver.navigate().to("https://www.demoqa.com/radio-button");

    }

    public void clickRadioButton(){
        commonFunctions.findElement(By.xpath("//label[text()='Yes']")).click();
       // driver.findElement(By.xpath("//label[text()='Yes']")).click();

    }

    public void validteYesRadioSelected(){
        Assert.assertEquals("Ye", commonFunctions.findElement(By.xpath("//p/span")).getText());
    }

    public void vallidateCorrectName(){
        WebElement name = driver.findElement(By.xpath("//p[@id='name']"));
        if(name.getText().contains("Tools QA")) {

        }else {
            Assert.assertTrue(false);
        }
    }

    public void clickSubmitButton(){
        WebElement btn = driver.findElement(By.xpath("//div/button"));
        btn.sendKeys(Keys.TAB);
        btn.click();
    }

    public void userEnterCurrentAndPermanentsAddress(){
        driver.findElement(By.id("currentAddress")).sendKeys("Current Address");
        driver.findElement(By.id("permanentAddress")).sendKeys("permanent address");
    }

    public void userEnterEmail(){
        driver.findElement(By.id("userName")).sendKeys("Tools QA");
        driver.findElement(By.id("userEmail")).sendKeys("toolsqa@gmail.com");
    }

    public void navigateToTextBoxPage(){
        commonFunctions.navigate("https://www.demoqa.com/text-box");
      //  driver.navigate().to("https://www.demoqa.com/text-box");
    }


}
