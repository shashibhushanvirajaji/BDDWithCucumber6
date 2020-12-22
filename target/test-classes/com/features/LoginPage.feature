Feature: Login Page Feature  

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Demo Web Shop"

  Scenario: Shop Logo
    Given user is on login page    
    Then Shop logo should be displayed
	
	Scenario: Menu Items
    Given user is on login page    
    Then Top Menu should be displayed with items
  
  Scenario: Logins into application
  	Given user is on login page  
  	When user enters username "shashi.virajaji@gmail.com"
  	And  user enters password "shashi12"
  	And Click on Login button 