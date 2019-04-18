Feature: Login to Application

Scenario: User logs into Home Insurance website with valid credentials
Given User is on the login page
When User enters username into username input field
And User enters passowrd into password field
Then User is directed to Get Started page