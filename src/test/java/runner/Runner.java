package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\Users\\MOKSHAGNA\\Desktop\\Automation\\src\\test\\resources\\features"
        ,glue = {"stepDefinition"}
        ,tags = "@TestCase1"
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,monochrome = true
        ,publish = true

)
public class Runner extends AbstractTestNGCucumberTests {

}