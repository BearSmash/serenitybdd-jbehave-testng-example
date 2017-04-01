package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.jBehave.storyPaths.strategies;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ScanningStepsFactory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * This strategy will find all the files ending in .story that are on the classpath, and use ScanningStepsFactory
 * to find all all steps in the features package.
 *
 * ScanningStepsFactory does not work when using instance variables in steps.
 *
 */
public class FindAllStoryPathsAndSteps extends AbstractStoryPathsAndStepsFactoryStrategy {

    public List<String> getStoryPaths(AbstractSerenityTestngSteps steps) {
        String filter = System.getProperty("story.filter", "**/*.story");
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(steps.getClass()), filter, null);
        logStoryPaths(storyPaths);
        return storyPaths;
    }

    @Override
    public InjectableStepsFactory getStepsFactory(Configuration configuration, AbstractSerenityTestngSteps steps) {
        return new ScanningStepsFactory(configuration, "com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.features");
    }
}
