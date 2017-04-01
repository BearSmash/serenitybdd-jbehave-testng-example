package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.runners;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.jBehave.storyPaths.strategies.AbstractStoryPathsAndStepsFactoryStrategy;
import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.jBehave.storyPaths.strategies.DeriveStoryPathsFromStepsLocationAndStoryName;
import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.InjectableStepsFactory;

import java.util.List;

public class AbstractSerenityTestngRunner extends SerenityStories {
    private AbstractSerenityTestngSteps steps;
    private AbstractStoryPathsAndStepsFactoryStrategy storyPathsAndStepsFactoryStrategy =
            new DeriveStoryPathsFromStepsLocationAndStoryName();

    @Override
    public InjectableStepsFactory stepsFactory() {
        return storyPathsAndStepsFactoryStrategy.getStepsFactory(this.configuration(), this.steps);
    }

    @Override
    public List<String> storyPaths() {
        List<String> storyPaths = storyPathsAndStepsFactoryStrategy.getStoryPaths(steps);
        return storyPaths;
    }

    public void setSteps(AbstractSerenityTestngSteps steps) {
        this.steps = steps;
    }
}
