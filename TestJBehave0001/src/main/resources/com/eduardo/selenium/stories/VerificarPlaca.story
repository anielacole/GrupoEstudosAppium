Narrative:
As a user
I want to search for an plate
In order to find out if I'm illegal

GivenStories:com/eduardo/selenium/stories/LoadGenymotion.story

Scenario: looking at the check plate screen
Given I'm at the Sinesp app home
When I click in the Veiculos button
Then the field plate letters is shown
When I type the plate ipx 3499
Then the field contains ipx 3499