Feature: User login flow

 Scenario Outline: User logs in with valid credentials
 
 Given User logs in with the credentials "<username>" and "<password>"
 Then User is navigated to the home page of the site
 And User logs out
 
 Examples:
 |username|password|
 |standard_user|secret_sauce|
 
 Scenario Outline: User tries to log in with invalid credentials
 
 Given User logs in with the credentials "<username>" and "<password>"
 Then Invalid credentials message appears
 
 
 Examples:
 |username|password|
 |standard_user|secre_sauce|

 Scenario Outline: User tries to log in with incomplete credentials
 
 Given User logs in with the credentials "<username>" and "<password>"
 Then Credentials required message appears for the given "<username>" and "<password>"

 
 Examples:
 |username|password|
 |standard_user|   |
 |        |secret_sauce|  