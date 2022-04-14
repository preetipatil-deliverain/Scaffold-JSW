package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"src\\test\\resources\\Feature\\WebAdmin\\Generic"},
		glue = {"stepDefinitions","Utility"},
		plugin = {
				"pretty",
				"json:target/cucumber-report/cucumber.json",
				"html:target/cucumber-report/cucumber.html"},
		monochrome = true,
		publish = false
		)

public class TestRunner {
}