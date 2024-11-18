Feature: Register the Ac and deletion

Scenario: Create New Account and Delete the ac then

Given User launch the Browser and navigate URL
And Verify that home page is visible
And Click on Sign in and Login Option
And Verify New User Signup! is visible
When User Sends username and email
|name | ranjith |
|email | ranjith1@mail.com |
And Click Signup button
And Verify that ENTER ACCOUNT INFORMATION is visible
And Fill details: Title, Name, Email, Password, Date of birth and Select two checkbox
And Fill Address details
|First name | Ranjith Kumar               |
|Last name  | Ganesh                      |
|Address    | No.1,Valli St,Santhosapuram | 
|State      | TamilNadu                   |
|City       | Chennai                     |
|ZipCode    | 600073                      |
|Mobile     | 9952301555									|
And Click on Create Account button
And Verify that ACCOUNT CREATED! is visible
And Click Continue button
And Verify that Logged in as username is visible
And Click Delete Account button
Then Verify that ACCOUNT DELETED! is visible and click Continue button











