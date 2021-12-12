Feature: Test Initial Page Search of Area

  Scenario: Navigate to swiggy and select a Area
    Given I open the browser
    And I navigate to swiggy.com
    When I select the Area "New Delhi" and click search
    Then I verify the location "New Delhi" is selected and displayed