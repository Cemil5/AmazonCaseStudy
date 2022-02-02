
Feature: Search

  Background:
    Given the user logged in to homepage
  @wip
  Scenario: Searching a desired item
    When the user enters "TaoTronics" to the search bar on the top part of the screen and clicks search
    Then the user confirms that search results include a "TaoTronics" product

  Scenario: Searching the desired item on the second page
    Given the user enters "TaoTronics" to the search bar on the top part of the screen and clicks search
    When the user navigates to second search page
    Then the user confirms that user is in the second page
    And the user confirms that search results include a "TaoTronics" product


  Scenario: Adding a product to the cart
    Given the user enters "TaoTronics" to the search bar on the top part of the screen and clicks search
    And the user navigates to second search page
    When the user clicks on the 3 rd product in current page
    And the user adds the selected product in current page to the cart
    Then the user verifies that Cart subtotal shows one item on the pop up window



