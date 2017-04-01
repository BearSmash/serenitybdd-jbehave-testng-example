package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.greetings.runners;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.runners.AbstractSerenityTestngRunner;
import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.greetings.steps.WhenBeingGreetedSteps;
import org.testng.annotations.Test;

public class WhenBeingGreetedRunnerTest extends AbstractSerenityTestngRunner {

    @Test
    public void customerShouldBeGreetedByName() throws Throwable{
        setSteps(new WhenBeingGreetedSteps());
        super.run();
    }
}