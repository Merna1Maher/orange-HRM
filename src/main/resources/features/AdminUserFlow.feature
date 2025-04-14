Feature: OrangeHRM User Flow
  Scenario: Add and delete a user in OrangeHRM
    Given User navigates to OrangeHRM login page
    When User logs in with username "Admin" and password "admin123"
    And User navigates to Admin section
    And User gets the current number of records
    And User clicks on Add and fills required data and save
    Then The number of records should increase by 1
    When User searches for the new user by username
    And User deletes the new user
    Then The number of records should decrease by 1