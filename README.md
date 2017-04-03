# serenitybdd-jbehave-testng-example
Example showing how serenitybdd (formerly thucydides) can be used with testNG and jBehave.


To run, simply do a maven clean install. You will then find the serenitybdd report in target/site/serenity/index.html <br />

This project proves: <br />
1 - You can use Serenity BDD with testNG (at least you can if you're also using jBehave) <br />
2 - It works with testNG xml suite files <br />
3 - It works with testNG's parallel test execution <br />

Things to note:<br />
You do lose some of serenity BDD's simplified conventions. <br />
It looks like it's necessary to override the stepsFactory() and storyPaths(), found in AbstractSerenityTestngRunner.java. <br /> 
I'm new to serenity BDD, so I may just be naive about how the conventions work. Please let me know if that's the case so that I can make this example simpler.

Getting started:<br />
The best place to start is with one of the feature runners like WhenBeingGreetedRunnerTest. From there, you can see how the jBehave steps are instantiated and follow the parent to see the configurations. 

For me, it's worth the one-time cost of extra complications to get the powerful features of testNG.
