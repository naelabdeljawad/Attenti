Feature: This is a feature file

  Background: Start Test
    Given I open browser

  Scenario: Attenti Conversion Test Scenario
    When I convert 30 "Celsius" to "Fahrenheit"
    Then I expect result to be "30°C= 86.00000°F"
    When I navigate back
    When I convert 50 "Meters" to "Feet"
    Then I expect result to be "50m= 164ft 0.5039400in"
    When I navigate back
    When I convert 10 "ounces" to "grams"
    Then I expect result to be "10oz= 283.4952g"

#  Scenario: Attenti Weather Test Scenario
#    Given I open browser
#    And I send request "20852 in USA"




