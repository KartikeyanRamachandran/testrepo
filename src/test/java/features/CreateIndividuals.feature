Feature: Create New Individuals With Diffrent Data

Background: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays
And Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher

@smoke
Scenario Outline:
Given Click Individuals from App Launcher
And Click on the Dropdown icon in the Individuals tab
And Click on New Individual
And Enter the Last Name as <lastName>
And Click save Individuals
Then Verify Individuals Name

Examples:
|lastName|
|karthik|