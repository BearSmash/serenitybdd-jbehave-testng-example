package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.greetings.steps;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WhenBeingGreetedSteps extends AbstractSerenityTestngSteps {
    String name;
    String greeting;

    @Given("a name")
    public void a_name(){
        this.name = "Bear Smash";
    }

    @When("greeting is requested")
    public void greeting_is_requested() {
        this.greeting = this.getGreeting(this.name);
    }

    @Then("the user is greeted by name")
    public void the_user_is_greeted_by_name() {
        assert greeting.toLowerCase().contains("hello");
        assert greeting.toLowerCase().contains(this.name.toLowerCase());
    }

    private String getGreeting(String name){
        return "Hello " + name;
    }
}
