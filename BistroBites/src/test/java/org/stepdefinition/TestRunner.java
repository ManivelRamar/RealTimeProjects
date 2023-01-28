package org.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "org.stepdefinition",
monochrome = true, dryRun = false, snippets = SnippetType.CAMELCASE,
publish = true, plugin = {"pretty","html:target/cucumber.html", 
	"json:target/cucumber.json",
	"junit:target/cucumber.xml"})
public class TestRunner {
	
}
