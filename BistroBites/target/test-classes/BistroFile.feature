Feature: To validate the functionalities of Bistrobites website

Background: 
Given launch the url to get homepage of the Bistrobites website

@TC1
Scenario: The user gives invalid username and password

When Click the Account button
And Give the wrong username and password
And Click the login button
Then check the output whether it is showing Invalid mobile number or not

@TC2
Scenario: The user successfully add the dosa

When Check a dropdown labeled Dosa and click it
And Select the Masala Dosa option
And Add it to cart
Then Verify the item in Cart

@TC3
Scenario: The user fills out the registration form and ignores the confirm password

When Click the Account button
And Fill out the registration form with dummy data and skip the confirm password text label
And Click the Register button
Then Get the pop-up please fill out the field

@TC4
Scenario: The user search for the coke can and check the price

When Click the search icon
And Search for coke
Then Check the price is 1.50 dollar or not

@TC5
Scenario: The user selects the Spanish Omelet

When Click the search icon
And Search for the Spanish Omelet and select it
And Select the option by probability
Then Check the dollar probabiltiy

@TC6
Scenario: The user read Our Policy
When Click the our story option
Then Check for spelling mistake

  