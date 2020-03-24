package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		      features = ".//FeatureFiles/",
		      glue = "stepDefinitions",
		      dryRun=false,
		      monochrome=true,
		      tags = {"@sanity"},
               plugin = { "pretty","json:target/cucumber.json"}
		    		 // plugin = { "pretty","html:Report"}
            )

public class TestRunn {

}
