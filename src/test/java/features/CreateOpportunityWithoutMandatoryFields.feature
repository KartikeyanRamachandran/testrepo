Feature: Create new Opportunity with diffrent data

Background: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays
And Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher
And Click on Opportunity tab
And Click on New Opportunity button
And Enter Opportunity name as Salesforce Automation by 'kumar'
And click Save Opportunity

@functional
Scenario:
Then Verify the Alert message