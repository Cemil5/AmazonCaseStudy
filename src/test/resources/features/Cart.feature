Feature: Showing the products on the Cart and deleting from Cart

  Background:
    Given the user logged in to homepage
    And the user enters "TaoTronics" to the search bar on the top part of the screen and clicks search
    And the user clicks on the 4 rd product in current page
    And the user adds the selected product in current page to the cart

  @wip
  Scenario: Showing the products on the Cart
    When the user navigates to cart page
    Then the user sees the products that was added to cart

  @wip
  Scenario: Deleting products from Cart
    Given the user navigates to cart page
    When the user deletes the first product from the cart
    Then the user confirms that this product deleted from the cart
