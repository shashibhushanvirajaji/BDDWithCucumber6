Feature: Welcome page feature

  Background: 
    Given user has already logged into application
      |username|password|
      |shashi.virajaji@gmail.com|shashi12|

  Scenario: Check user is on welcome page
  Then validate logout link
  
  Scenario: Welcome text
  Then validate welcome page