Feature: Create New Dashboard With Diffrent Data

Background: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays
And Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher

@sanity
Scenario Outline:
Given Click Dashboards from App Launcher
And Click on the New Dashboard option
And Enter Name as Salesforce Automation by <yourName>
And Click on Create
And Click Save Dashboard
Then Verify Dashboard name

Examples:
|yourName|
|karthik|
