

Feature: Login
@sanity
Scenario: Successful login with valid credentials
    Given user launch Chrome browser
    When user open the url "https://admin-demo.nopcommerce.com/login" 
    Then user enter valid userid "admin@yourstore.com" and password "admin"
    And click to the login
    Then page title should be "Dashboard / nopCommerce administration"
    When user need to click logout
    Then close the browser

@regression
 Scenario Outline: Login data driven
     Given user launch Chrome browser
    When user open the url "https://admin-demo.nopcommerce.com/login" 
    Then user enter valid userid "<email>" and password "<pass>"
    And click to the login
    Then page title should be "Dashboard / nopCommerce administration"
    When user need to click logout
    Then close the browser
    
    Examples:
| email | pass|
| admin@yourstore.com | admin|
| admin@yourstore.com | admin123|