@FLTAP-692
Feature: With parameters and Scenario Outline

  Background:
    Given The user is on the login page

  @FLTAP-691
  Scenario Outline: All users can log in with valid credentials
    Given Login as a "<userType>"
    When The user enter "<username>" and "<password>"
    Then The user is on the "<pageSubTitle>" page
    Examples:
      | userType      | username        | password    | pageSubTitle    |
      | Driver        | user1           | UserUser123 | Quick Launchpad |
      | Sales Manager | salesmanager101 | UserUser123 | Dashboard       |
      | Store Manager | storemanager51  | UserUser123 | Dashboard       |

  @FLTAP-751
  Scenario Outline: The user can not login with invalid credentials - Negative
    When The user tries to login with "<username>" and "<password>"
    Then The user can not login and see Invalid username or password.
    Examples:
      | username         | password    |
      | user1            | asdf        |
      | asdf             | UserUser123 |
      | Store Manager51  | asdf        |
      | asdfg            | UserUser123 |
      | Sales Manager101 | asdf        |
      | asdfgh           | UserUser123 |

  @FLTAP-752
  Scenario Outline: "Please fill out this field" message should be displayed
    When The user tries to login with "<username>" and "<password>"
    Then "Lütfen bu alanı doldurun." message should be displayed
    Examples:
      | username         | password    |
      |                  | UserUser123 |
      |                  |             |


  @FLTAP-924
  Scenario: "Please fill out this field" message should be displayed if the password is empty
    When The users try to login with "user1" and ""
    Then "Lütfen bu alanı doldurun." message should be displayed if password is empty



  @FLTAP-753
  Scenario: "Forgot Password" page after clicking on the "Forgot your password?" link
    When The user click the "Forgot your Password?" link
    Then The user land on "Forgot Password" page

  @FLTAP-754
  Scenario: "Remember Me" link exists and is clickable on the login page,
    When The user can see "Remember Me" link
    Then  The link is clickable

  @FLTAP-756
  Scenario: the "password" is entered in bullet signs by default (like ****)
    When  The user enter the "password"
    Then  The password in bullet sign by default

  @FLTAP-758
  Scenario: ‘Enter’ key of the keyboard is working correctly on the login page
    When  The user enter username and password and press the ENTER key
    Then  The Enter key is working


  @FLTAP-760
  Scenario Outline: Login in the user page
    When The user tries to login with "<username>" and "<password>"
    And The users should see "<userType>" name in the profile menu

    Examples:
      | userType      | username        | password    |
      | Driver        | user1           | UserUser123 |
      | Sales Manager | salesmanager101 | UserUser123 |
      | Store Manager | storemanager51  | UserUser123 |



