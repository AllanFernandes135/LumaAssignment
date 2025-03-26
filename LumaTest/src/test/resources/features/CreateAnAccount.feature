Feature: Create An Account
#
  Background:
   Given I navigate to  luma home page
   Then I should see "Home Page" header displayed
    And  I click on the "Create an Account" link

  @TestEndToEnd
  Scenario:To verify user is able to create account using valid details
    And I enter "Tester" in the "First Name" textbox
    And I enter "Dias" in the "Last Name" textbox
    And I enter "Unique" in the "Email" textbox
    And I enter "Password@123" in the "Password" textbox
    And I enter "Password@123" in the "Confirm Password" textbox
    And I click on the "Create an Account" button
    Then I should see "My Account" header displayed
    Then I should see "Successfully registered" validation message

  @Test01
  Scenario:To Verify validation messages are displayed when user clicks on 'Create an Account" without filling any details
    When I click on the "Create an Account" button
    Then I should see "This is a required field" validation message for "First Name" textbox
    Then I should see "This is a required field" validation message for "Last Name" textbox
    Then I should see "This is a required field" validation message for "Email" textbox
    Then I should see "This is a required field" validation message for "Confirm Password" textbox
    Then I should see "This is a required field" validation message for "Password" textbox

   @Test02
  Scenario:To Verify validation messages are displayed when user keeps First name and last Name field blank
      And I enter "testsc@ymail.com" in the "Email" textbox
      And I enter "pass3213dsad#" in the "Password" textbox
      And I enter "pass3213dsad#" in the "Confirm Password" textbox
      When I click on the "Create an Account" button
      And I scroll up
      Then I should see "This is a required field" validation message for "First Name" textbox
      And  I should see "This is a required field" validation message for "Last Name" textbox


  @Test03
  Scenario:To Verify validation messages are displayed when user add blank space in all the fields
    And I enter "  " in the "First Name" textbox
    And I enter "  " in the "Last Name" textbox
    And I enter "  " in the "Email" textbox
    And I enter "  " in the "Password" textbox
    And I enter "  " in the "Confirm Password" textbox
    When I click on the "Create an Account" button
    Then I should see "This is a required field" validation message for "Confirm Password" textbox
    Then I should see "This is a required field" validation message for "Password" textbox
     And I scroll up
     Then I should see "This is a required field" validation message for "Email" textbox
    Then I should see "This is a required field" validation message for "First Name" textbox
    Then I should see "This is a required field" validation message for "Last Name" textbox

  @Test04
  Scenario:To Verify validation messages is  displayed when user add only numbers in the password textbox
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "12345678" in the "Password" textbox
    Then I should see "Not Meeting Minimum Type Of Char" validation message for "Password" textbox


  @Test05
  Scenario:To Verify validation messages is  displayed when user adds only 1 character in the password textbox
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "c" in the "Password" textbox
    Then I should see "Not Meeting Minimum length" validation message for "Password" textbox


  @Test06
  Scenario:To Verify validation messages is  displayed when user adds only Alphanumeric characters  in the password textbox
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "abcd1234" in the "Password" textbox
    Then I should see "Password not meeting all conditions" validation message for "Password" textbox

  @Test07
  Scenario:To Verify validation messages is  displayed when the confirm password doesn’t match  password textbox
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "abcd1234$#" in the "Password" textbox
    And I enter "abcd1234$a" in the "Confirm Password" textbox
    And   I click on the "Create an Account" button
    Then I should see "Password Not Matching" validation message for "Confirm Password" textbox


   @Test08
  Scenario:To Verify validation messages is  displayed when  incorrect email address is used to create an account
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc123" in the "Email" textbox
     And I enter "abcd1234$#" in the "Password" textbox
     And I enter "abcd1234$#" in the "Confirm Password" textbox
     And  I click on the "Create an Account" button
    Then I should see "Incorrect Email Format" validation message for "Email" textbox

  @Test09
  Scenario:To Verify validation messages is  displayed when incorrect data is added  in 1 or more mandatory fields
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "abcd1234$#" in the "Password" textbox
    And  I click on the "Create an Account" button
    Then I should see "This is a required field" validation message for "Confirm Password" textbox
    Then I should see "This is a required field" validation message for "Email" textbox


  @Test10
  Scenario:To Verify validation messages is  displayed when user adds only letters in the password textbox
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "cdsadsdasda" in the "Password" textbox
    Then I should see "Password not meeting all conditions" validation message for "Password" textbox

  @Test11
  Scenario:To Verify validation messages is displayed for Leading and trailing space added to password
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "testsc@ymail.com" in the "Email" textbox
    And I enter "1a@     " in the "Password" textbox
    Then I should see "Password having space" validation message for "Password" textbox

 @Test12
  Scenario:To Verify the sign-up process with an email address that is already present in the system
    And I enter "Gun" in the "First Name" textbox
    And I enter "Radio" in the "Last Name" textbox
    And I enter "test@gmail.com" in the "Email" textbox
    And I enter "12345@abc" in the "Password" textbox
    And I enter "12345@abc" in the "Confirm Password" textbox
    And  I click on the "Create an Account" button
    Then I should see "Account already exists with current email" validation message for "Create Account" textbox

   @Test13
  Scenario:To Verify if the password meets the required strength criteria
      And I enter "abcdef" in the "Password" textbox
     Then I should see the password strength as "Weak"
      And I clear the "Password" textbox
      And I enter "abcd123@" in the "Password" textbox
      Then I should see the password strength as "Medium"
      And I clear the "Password" textbox
      And I enter "abcd1234!@#$" in the "Password" textbox
      Then I should see the password strength as "Strong"
      And I clear the "Password" textbox
      And I enter "Password@123" in the "Password" textbox
      Then I should see the password strength as "Very Strong"
