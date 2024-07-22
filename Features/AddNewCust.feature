

Feature: Customer
@sanity
Scenario: Adding New Customer
    Given user launch Chrome browser
    When user open the url "https://admin-demo.nopcommerce.com/login" 
    Then user enter valid userid "admin@yourstore.com" and password "admin"
    And click to the login
    When user click to to Customers
    And user also click to the Customer link
    Then user need to click to Add New
    And user need to enter Customer information
    And click to the save
    Then User can also see the confirmation msg "added successfully"
    And close the browser

 @sanity
Scenario: Searching Customer by mail id
    Given user launch Chrome browser
    When user open the url "https://admin-demo.nopcommerce.com/login" 
    Then user enter valid userid "admin@yourstore.com" and password "admin"
    And click to the login
    When user click to to Customers
    And user also click to the Customer link
    When user need to enter mail id "steve_gates@nopCommerce.com"
    And click to the Search button 
    Then verify the email is present
    And close the browser
    
    
  @regression  
    Scenario: Searching Customer by mail id
    Given user launch Chrome browser
    When user open the url "https://admin-demo.nopcommerce.com/login" 
    Then user enter valid userid "admin@yourstore.com" and password "admin"
    And click to the login
    When user click to to Customers
    And user also click to the Customer link
    When user need to enter First name and Last name
    And click to the Search button 
    Then verify the name is present
    And close the browser