Feature: Register the Account

Scenario: Register the Account with mandatory fields
Given User launch url and navigate to MyAccount
And User clicks on Register
When User the enter below mandatory details
|Firstname |Ranjith |
|lastname |Ganesh |
|email |ranjith123@gmail.com | 
|phone |1234567890 |
|password |12345 |
|ConfirmPwd |12345 |
And User selects privacy policy
And User clicks on continue button
Then User created account successfully

