Feature: Create new Opportunity with diffrent data

Background: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays
And Click on toggle menu button from the left corner 
And Click view All and click Sales from App Launcher

@smoke
Scenario Outline:
Given Click on Opportunity tab
And Click on New Opportunity button
And Enter Opportunity name as Salesforce Automation by <nameofopportunities>
And Choose close date as Today
And Select Stage as Need Analysis
And click Save Opportunity
Then VerifyOppurtunity Name

Examples:
|nameofopportunities|
|Karthikeyan|