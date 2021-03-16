Feature: Authorization

  Scenario: Registration Flow Validation via App
  As a new user I should be able to see a screen with demo login and password
  when I try to authorize with Demo User

    Given the User launches George App
    And  the Welcome Tour Screen is opened
    When the User swipes all Welcome Tour Screens
    And the User chooses Login to George
    And the User chooses Login to with Demo User
    And the User fill a Password
    And the User presses a Login button
    Then the User sees a Screen where he is proposed to choose "Fingerprint" "PIN" or "Pattern" access method
