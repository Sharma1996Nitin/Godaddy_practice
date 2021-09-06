Feature:Launch Browser and open Amazon Site
  @run
  Scenario: Home page of Amazon site
    Given User on google page
    When User hit the Amazon URL
    Then Print and validate the title of the page
