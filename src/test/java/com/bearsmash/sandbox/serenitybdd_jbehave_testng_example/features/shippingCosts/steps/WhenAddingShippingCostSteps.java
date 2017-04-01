package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features.shippingCosts.steps;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WhenAddingShippingCostSteps extends AbstractSerenityTestngSteps {
    double itemCost;
    double standardShippingCost = 4.00;
    double totalCost;

    @Given("an item of cost 15.00 is in the cart")
    public void an_item_of_cost_15_00_is_in_the_cart(){
        this.itemCost = 15.00;
    }

    @When("the customer chooses standard shipping")
    public void the_customer_chooses_standard_shipping() {
        totalCost = itemCost + standardShippingCost;
    }

    @Then("the customer sees a total cost of 19.00")
    public void the_customer_sees_a_total_cost_of_19_00() {
        assert totalCost == 19.00;
    }
}
