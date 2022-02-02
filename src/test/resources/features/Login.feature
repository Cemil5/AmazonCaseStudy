Feature: Navigating main page and login

  Scenario: navigating to main page
    When the user navigates to main page
    Then the user sees that the main page is loaded


  Scenario: login using a valid account
    Given the user navigates to main page
    When the user clicks Hello, Sign in Account & List button
    And the user enters valid email and password
    Then the user sees username after Hello word next to Language flag