Feature: Login into Salesforce Application

@regression
Scenario: Positive Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '12345@Qwerty'
And Click on Login
Then Home screen Displays

@regression
Scenario: Nagative Login
Given Type username as 'karthikeyan@kkrinfotech.com'
And type password as '123@Qwer'
And Click on Login
But Verify error Displayed