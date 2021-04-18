package PageObjects;

import Utility.BasePage;
import Utility.CommonFunctions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoQAPage extends CommonFunctions {


    public DemoQAPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);

   }
    //public By radioButton = By.xpath("//label[text()='Yes']");


    @FindBy(how= How.XPATH,using="//label[text()='Yes']")
    public WebElement radioButton;


    public void navigateTORadioPage(){
        navigate("https://www.demoqa.com/radio-button");

    }

    public void clickRadioButton(){
        findElement(By.xpath("//label[text()='Yes']")).click();

    }

    public void validteYesRadioSelected(){
        Assert.assertEquals("Ye", findElement(By.xpath("//p/span")).getText());
    }

    public void vallidateCorrectName(){
        WebElement name = findElement(By.xpath("//p[@id='name']"));
        if(name.getText().contains("Tools QA")) {

        }else {
            Assert.assertTrue(false);
        }
    }

    public void clickSubmitButton(){
        WebElement btn = findElement(By.xpath("//div/button"));
        btn.sendKeys(Keys.TAB);
        btn.click();
    }

    public void userEnterCurrentAndPermanentsAddress(){
       findElement(By.id("currentAddress")).sendKeys("Current Address");
       findElement(By.id("permanentAddress")).sendKeys("permanent address");
    }

    public void userEnterEmail(){
        findElement(By.id("userName")).sendKeys("Tools QA");
        findElement(By.id("userEmail")).sendKeys("toolsqa@gmail.com");
    }

    public void navigateToTextBoxPage(){
         navigate("https://www.demoqa.com/text-box");
    }

}
