Feature: News

  Scenario: User should see news list when opened the app
    Given The app started
    Then I see News list screen

  Scenario: User can search "US" for specific news
    Given The app started
    And I see News list screen
    When I input "US" in search box
    And I click on search button
    Then I see only 1 news

  Scenario: User can search "th" for specific news
    Given The app started
    And I see News list screen
    When I input "th" in search box
    And I click on search button
    Then I see only 2 news

  Scenario: User can search "TH" for specific news
    Given The app started
    And I see News list screen
    When I input "TH" in search box
    And I click on search button
    Then I see "No data" on screen