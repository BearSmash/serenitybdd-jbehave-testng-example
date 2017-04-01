package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.jBehave.storyPaths.strategies;

import com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps.AbstractSerenityTestngSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * This strategy will use the steps file location and story name to find the path to the story file. It is only meant
 * to find exactly one file. The InstanceStepsFactory is used with the instance of the steps file that matches
 * the story file.
 *
 * Will not support having a story with matching steps that are in more than on file.
 */
public class DeriveStoryPathsFromStepsLocationAndStoryName extends AbstractStoryPathsAndStepsFactoryStrategy {

    @Override
    public InjectableStepsFactory getStepsFactory(Configuration configuration, AbstractSerenityTestngSteps steps) {
        return new InstanceStepsFactory(configuration, steps);
    }

    @Override
    public List<String> getStoryPaths(AbstractSerenityTestngSteps steps) {
        List<String> storyPaths = deriveStoryPathsFromStepsLocationAndStoryName(steps);
        guaranteeStoryPathsListSizeIsExactlyOne(storyPaths, steps);
        logStoryPaths(storyPaths);
        return storyPaths;
    }

    private List<String> deriveStoryPathsFromStepsLocationAndStoryName(AbstractSerenityTestngSteps steps){
        String searchIn = codeLocationFromClass(steps.getClass()).getFile();
        String anyPathToTheStory = "**/" + steps.getStoryName() + ".story";
        String excludeNothing = "";
        return new StoryFinder().findPaths(searchIn, anyPathToTheStory, excludeNothing);
    }

    private void guaranteeStoryPathsListSizeIsExactlyOne(List<String> storyPaths, AbstractSerenityTestngSteps steps){
        if(storyPaths == null || storyPaths.size() == 0){
            throw new NullPointerException("Unable to find story file for '" + steps.getStoryName() + "'.");
        }else if(storyPaths.size() > 1){
            throw new IllegalArgumentException("More than 1 stories exist with StoryName = '" + steps.getStoryName()
                    + "'.\nStory Paths - " + storyPaths
                    + "\nUnable to proceed - Story Name must be unique.");
        }
    }
}
