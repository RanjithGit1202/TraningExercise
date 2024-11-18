
Feature: Login Functionality

Scenario: Login with Valid Credential

Given User launch the url 
And Go to MyAccount Tab and click on Login
When User enters Valid Email "sivranjith@gmail.com" into email field
And  User enter valid pwd "123456" into pwd field
And User clicks on Login button
Then User successfully login and verify if able to see home page

 