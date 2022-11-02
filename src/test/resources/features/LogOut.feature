Feature: Log out Functionality

  Background:
    Given The user inside the Quick Launchpad or Dashboard



    Scenario Outline : Successful login with valid credentials

      Given Login as a "<userType>"
      When The user enter "<username>" and "<password>"
      Then The user is on the "<pageSubTitle>" page
      Examples:
        | userType      | username        | password    | pageSubTitle    |
        | Driver        | user1           | UserUser123 | Quick Launchpad |
        | Sales Manager | salesmanager101 | UserUser123 | Dashboard       |
        | Store Manager | storemanager51  | UserUser123 | Dashboard       |

      Scenario: The user can log out by using the log out button
        Given The user inside the Quick Launchpad or Dashboard
        When The user click the log out button
        And The User should land on the "Login" page

        Scenario: The user can not go to the home page again
          Given The user click the log out button
          When The User should land on the "Login" page



