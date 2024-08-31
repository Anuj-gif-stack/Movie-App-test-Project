Feature: MovieApp Header Section UI and Functionality
  As a user of the MovieApp
  I want to be able to log in to my account
  So that I can access personalized features and functionality

  Scenario: Header Section UI
    Given I am on the Login Page
    When I enter valid username and password
    And I click on login Button
    And I should be redirected to the home page
    And I want to check the website logo
    Then I want to check the Home, Popular text

  Scenario: Header Section Functionality
    Given I am on the Login Page
    When I enter valid username and password
    And I click on login Button
    And I should be redirected to the home page
    And I check the navigation to Home page and Popular page
    Then I check the navigation to account page