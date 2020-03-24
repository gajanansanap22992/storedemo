Feature: Add Customer
@me
Scenario: User add customer details
Given user open browser 
	When user enter url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F" 
	And user get page with title "Your store. Login" 
	And user enter email as " admin@yourstore.com" and password as "admin"
	When user click on login button 
	Then user get the page with "Dashboard / nopCommerce administration" 
	When user click on customers menu
	And user click on customers item from customers menu
	#And user select customer role
	#And user click on addNew button
	And user enter customers details
	#And user click on save button
	And user get successfull message as "The new customer has been added successfully."	
	And user click on logout button
    Then user close browser