package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Resources/features",
				 glue= {"src/test/java/stepdefinitions"},
				 plugin={"pretty",
						  "html:target/CucumberReport.html",
		                  "json:target/CucumberReport.json",
		                  "xml:target/CucumberReport.xml"
							},
				  publish = true
)
public class TestMyRunner{
	
}
