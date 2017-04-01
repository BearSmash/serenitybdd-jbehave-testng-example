package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.jBehave.storyPaths.strategies;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * There are lots of ways to create story paths and steps factories.
 * The strategy pattern makes it a little easier to try different ones to get what you want.
 * This was mostly used during development as I wasn't sure what strategy would work.
 */
public abstract class AbstractStoryPathsAndStepsFactoryStrategy {

    private static final Logger log = LoggerFactory.getLogger(AbstractStoryPathsAndStepsFactoryStrategy.class);
    public abstract List<String> getStoryPaths(AbstractSerenityTestngSteps steps);
    public abstract InjectableStepsFactory getStepsFactory(Configuration configuration, AbstractSerenityTestngSteps steps);

    void logStoryPaths(List<String> storyPaths){
        log.debug("Story paths found: {}", String.join(", ",storyPaths));
    }
}
