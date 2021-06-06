package io.cucumber.skeleton.StepsDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.skeleton.Belly;
import io.cucumber.skeleton.suport.ReaderCSV;

import java.util.ArrayList;


public class StepdefsX {

    ArrayList<String> result = null;

    @Before
    public void doSomethingBefore(Scenario scenario) throws Exception {
        String CT = scenario.getSourceTagNames().iterator().next();
        System.out.println("TEST CN: " + CT);
        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);
        String csv_path = (cwd + "\\data_mass\\data_mass_scenarioX.csv");
        ReaderCSV csv_file = new ReaderCSV();
        result = csv_file.oneByOne(csv_path, CT);
    }

    @Given("I have X cukes in my belly")
    public void I_have_cukes_in_my_belly() throws Throwable {
        Belly belly = new Belly();
        belly.eat(Integer.parseInt(result.get(1).trim()));
    }

    @When("I wait X hour")
    public void i_wait_hour() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("\n" + result.get(2));
    }

    @Then("my belly should X")
    public void my_belly_should_growl() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(result.get(3));
    }


}
