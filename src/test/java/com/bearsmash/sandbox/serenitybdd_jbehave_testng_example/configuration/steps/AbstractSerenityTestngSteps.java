package com.bearsmash.sandbox.serenitybdd_jbehave_testng_example.configuration.steps;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractSerenityTestngSteps {
    private String storyName;

    public String getStoryName(){
        if(this.storyName == null){
            setStoryName(defaultStoryName());
        }
        return this.storyName;
    }

    public void setStoryName(String storyName){
        this.storyName = storyName;
    }

    private String defaultStoryName(){
        return stepsClassNameToStoryName();
    }

    private String stepsClassNameToStoryName(){
        String simpleClassName = this.getClass().getSimpleName();
        return (simpleClassName.endsWith("Steps")
                ? StringUtils.removeEnd(simpleClassName, "Steps")
                :  null);
    }
}