Feature: Create New Account With Diffrent Data

Background: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays
And Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher

@sanity
Scenario Outline:
Given Click on Accounts tab
And Click on New Account button
And Enter account name as <accountName>
And Select Ownership as Public
And Click Save Account
Then Verify Account name

Examples:
|accountName|
|Krithvik|