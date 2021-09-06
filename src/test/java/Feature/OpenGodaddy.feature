Feature:Launch Browser and open Godaddy Site
  Scenario: Home page of Godaddy site
    Given User on the google page
    When User hit the Godaddy URL
    Then Print the title of the page
    And Login into Godaddy Site
