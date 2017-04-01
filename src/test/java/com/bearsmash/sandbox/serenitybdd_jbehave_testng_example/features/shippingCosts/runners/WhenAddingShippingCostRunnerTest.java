package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.shippingCosts.runners;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.runners.AbstractSerenityTestngRunner;
import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.shippingCosts.steps.WhenAddingShippingCostSteps;
import org.testng.annotations.Test;

public class WhenAddingShippingCostRunnerTest extends AbstractSerenityTestngRunner {

    @Test
    public void customerShouldSeeUpdatedTotalAfterChoosingShipping() throws Throwable{
        setSteps(new WhenAddingShippingCostSteps());
        super.run();
    }
}