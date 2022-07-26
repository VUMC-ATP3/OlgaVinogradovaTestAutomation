Feature: Sauce Demo login, inventory page, cart page, checkout
  User is able to login with correct credentials, add product to card and checkout.
  Test correct error messages on the checkout page.

  @chromeBrowser
  Scenario: User is able to login with correct credentials
    Given user is navigating to 'https://www.saucedemo.com/'
    When user enters correct username 'standard_user' and password 'secret_sauce'
    And user clicks login button below
    Then user is successfully logged in website

  @chromeBrowser
  Scenario: User is able to add product to cart
    Given user is navigating to 'https://www.saucedemo.com/'
    When user enters correct username 'standard_user' and password 'secret_sauce'
    And user clicks login button below
    When user add one product to cart
    And navigate to cart page
    Then user can find added product on the cart page

  @chromeBrowser
  Scenario: User is able to fill information on checkout page and check data on checkout overview
    Given user is navigating to 'https://www.saucedemo.com/'
    When user enters correct username 'standard_user' and password 'secret_sauce'
    And user clicks login button below
    When user add one product to cart
    And navigate to cart page
    When user navigated to checkout
    When user enters first name 'Olga', last name 'Vinogradova' and Postal Code 'LV-3602'
    And user clicks continue button
    Then user can find product on checkout overview page

  @chromeBrowser
  Scenario: User is able to confirm purchase and press 'Back Home' button
    Given user is navigating to 'https://www.saucedemo.com/'
    When user enters correct username 'standard_user' and password 'secret_sauce'
    And user clicks login button below
    When user add one product to cart
    And navigate to cart page
    When user navigated to checkout
    When user enters first name 'Olga', last name 'Vinogradova' and Postal Code 'LV-3602'
    And user clicks continue button
    When user clicks finish button
    Then user can see on the website that checkout is sucessfully completed
    And user can click back home button


  @chromeBrowser
  Scenario Outline: User sees correct error message on the checkout page
    Given user is navigating to 'https://www.saucedemo.com/'
    When user enters correct username 'standard_user' and password 'secret_sauce'
    And user clicks login button below
    When user add one product to cart
    And navigate to cart page
    When user navigated to checkout
    When user enters first name '<first_name>', last name '<last_name>' and Postal Code '<postal_code>'
    And user clicks continue button
    Then user sees error text '<error_text>'
    Examples:
      | first_name | last_name   | postal_code | error_text                     |
      |            | Vinogradova | LV-3602     | Error: First Name is required  |
      | Olga       |             | LV-3602     | Error: Last Name is required   |
      | Olga       | Vinogradova |             | Error: Postal Code is required |
      |            |             |             | Error: First Name is required  |



