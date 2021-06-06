package io.cucumber.skeleton;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
plugin = {
        "pretty",
        "io.cucumber.skeleton.StepsDefinition.BaseClassStep",
        "html:target/cucumber",
        "json:target_json/cucumber.json",
})
public class RunCucumberTest {

}
