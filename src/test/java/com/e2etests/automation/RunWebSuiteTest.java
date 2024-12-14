package com.e2etests.automation;

import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
* The Test Runner File uses the @RunWith() Annotation from JUnit for executing tests.
*/
@RunWith(Cucumber.class)

/**
* The @CucumberOptions Annotation is used to define the location of feature files, step definitions, reporting
* integration.
*/
@CucumberOptions(
	features = {"src/spec/features"},
	plugin = {"pretty","html:target/cucumber-report.html"},
	tags = ("@module_register"),
	//glue = {"com.e2etests.automation.step_definitions"},
	monochrome = true,
	snippets = CAMELCASE
		
			
		)

public class RunWebSuiteTest {

}
