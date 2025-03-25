Feature: Sign In
#
  Background:
    Given I navigate to  luma home page
    Then I should see "Home Page" header displayed
    And  I click on the "Sign In" link


  @Test01
  Scenario:To verify existing user is able to login to their account using valid credentials
    And I enter "Existing User Email" in the "Email Login" textbox
    And I enter "Existing User Password" in the "Password Login" textbox
    And I click on the "Sign In" button
    Then I should see welcome user message

#  @Test01
  Scenario: To Verify validation message is displayed when user clicks on 'Sign in' without filling any details
    And I click on the "Sign In" button
    Then I should see "This is a required field" validation message for "Email" textbox
    Then I should see "This is a required field" validation message for "Password" textbox

#  @Test01
  Scenario: To Verify validation message is displayed when user add invalid data  in email and password textbox
    And I enter "test3A@gmail.com" in the "Email Login" textbox
    And I enter "Test@1234" in the "Password Login" textbox
    And I click on the "Sign In" button
    Then I should see "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later" validation message

#  @Test01
  Scenario:To Verify validation messages is  displayed when  incorrect email address is used for login
    And I enter "test3A2" in the "Email Login" textbox
    And I click on the "Sign In" button
    Then I should see "Incorrect Email login Format" validation message for "Email login" textbox
