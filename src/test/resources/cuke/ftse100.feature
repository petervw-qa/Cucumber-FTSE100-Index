Feature: To check the highest rise and lowest faller on the FTSE100 index displayed on Hargreaves Lansdown

  Scenario: Get Highest Riser
    Given that I can navigate to HL
    When I click on the Risers link
    And I find the highest table entry
    Then I can display it

  Scenario: Get Lowest Faller
		Given that I can navigate to HL
    When I click on the Fallers link
    And I find the highest table entry
    Then I can display it


