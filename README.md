# xerotest
This is a sample automated tests in relation to Xero technical exam

There are two test cases defined for below user story:
As a Xero user
I want to be able to add an "ANZ (NZ)" bank account inside any Xero Organization

Scenario 1:
    Given I login as a user from Demo Company
    When I add a single ANZ Bank Account with CC as account type
    Then I verify that the bank account is added successfully

Scenario 2:
    Given I login as a user from Demo Company
    When I add multiple ANZ Bank Accounts with different account types
    Then I verify that each bank account is added successfully

Notes:
I create my own login credentials and use the Demo Company as a sample organization

Plans for updates/optimization:
-To make it in a BDD format using Cucumber
-To add Web driver/browser set up in a separate class file
-Create a report


To execute this test:
Clone the project from Github as a maven project
Right click and Run the "AddBankAccount" class file under /test/java/ folder
Both two test cases should pass


