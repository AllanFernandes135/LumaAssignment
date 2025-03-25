Feature: Home

#  @Test01
#Scenario: To Verify user is  navigated to 'Whats new' section on clicking  the provided link
#  When I navigate to  luma home page
#  Then I should see "Home Page" header displayed
#
#
#  @Test01
#  Scenario: To Verify user is navigated to 'Customer Login'  section on clicking  'Sign in'
#    When I navigate to  luma home page
#    And I click on the "Sign In" link
#   Then I should see "Customer Login" header displayed/

#    @Test01
  Scenario: To Verify user is navigated to 'Create New Customer Account'  section on clicking  'Create an Account'
    When I navigate to  luma home page
    And I click on the "Create an Account" link
    Then I should see "Create New Customer Account" header displayed