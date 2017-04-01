Narrative:
As a user
I want to be greeted by name
So that I know I am signed in correctly

Scenario: Should say hello to user by name
Given a name
When greeting is requested
Then the user is greeted by name