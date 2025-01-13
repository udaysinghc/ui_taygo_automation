@signup
Feature: Test Signup Functionality

  Scenario Outline: Test Signup with invalid user error message data
    Given user on the Signup page
    When user enter firstName "<firstName>", lastName "<lastName>", email "<email>", mobile "<mobileNumber>"
    Then user verify error messages for firstName "<fnError>", lastName "<lnError>", email "<emailError>",and  mobileNum "<mobileNum>"
    Examples:
      | firstName | lastName | email          | mobileNumber | fnError  | lnError  | emailError            | mobileNum                       |
#      |           |          |                |              | Required | Required | Required              | Required                        |
      |           | Test     | Test@gmail.com | 8794568798   | Required |          |                       |                                 |
#      | Test      |          | Test@gmail.com | 8794568798   |          | Required |                       |                                 |
#      | Test      | Test     |                | 8794568798   |          |          | Required              |                                 |
#      | Test      | Test     | Test           | 8794568798   |          |          | Must be a valid email |                                 |
#      | Test      | Test     | Test@gmail.com |              |          |          |                       | Required                        |
#      | Test      | Test     | Test@gmail.com | 879456879    |          |          |                       | Please enter valid phone number |

# test
#  @signupWithLoanOfficer
#  Scenario Outline: User signup with loan officer
#    Given  user on the Signup page
#    When user enter firstName "<FirstName>", lastName "<LastName>", mobile "<MobileNumber>"
#    And user set the password "<Password>"
#    And user fill the individual information JobTitle "<JobTitle>" NMLS_ID "<NMLSID>" Address1 "<Address1>" Address2 "<Address2>" City "<City>" ZipCode "<ZipCode>" State "<State>"
#    And user fill the company information CompanyName "<CompanyName>" CompanyNMLSID "<CompanyNMLSID>" CompanyType "<CompanyType>" Address1 "<Address1>" Address2nd "<Address2>" City "<City>" ZipCode "<ZipCode>" State "<State>" LoanOfficers "<LoanOfficers>" WebSiteURL "<WebSiteURL>"
#    And user verify the cell phone number "<MobileNumber>"
#    And user upload a profile picture
#    And user select a package
#    And user experiences consistent brand aesthetics
#    And user enter Name on Card "<NameOnCard>", Card number "<CardNumber>", date "<Date>" and CVV "<Cvv>"
#    Then verify the user dashboard
#    And user verify the my apps
#    Examples:
#      | FirstName   | LastName | MobileNumber | Password  | JobTitle | NMLSID | Address1 | Address2 | City     | ZipCode | State  | CompanyName | CompanyNMLSID | CompanyType | LoanOfficers | WebSiteURL                | NameOnCard | CardNumber       | Date  | Cvv |
#      | loanofficer | test     | 5182610312   | Test@1234 | TestJob  | 123456 | USA      | UK       | New York | 10001   | Alaska | SMTP_Test   | 123456        | Retail      | 5            | https://cloud.taygo.tech/ | test       | 4242424242424242 | 01/28 | 123 |

#  @signupWithCompanyPackage
#  Scenario Outline: User signup with company package
#    Given  user on the Signup page
#    When user enter firstName "<FirstName>", lastName "<LastName>", mobile "<MobileNumber>"
#    And user set the password "<Password>"
#    And user fill the individual information JobTitle "<JobTitle>" NMLS_ID "<NMLSID>" Address1 "<Address1>" Address2 "<Address2>" City "<City>" ZipCode "<ZipCode>" State "<State>"
#    And user fill the company information CompanyName "<CompanyName>" CompanyNMLSID "<CompanyNMLSID>" CompanyType "<CompanyType>" Address1 "<Address1>" Address2nd "<Address2>" City "<City>" ZipCode "<ZipCode>" State "<State>" LoanOfficers "<LoanOfficers>" WebSiteURL "<WebSiteURL>"
#    And user verify the cell phone number "<MobileNumber>"
#    And user upload a profile picture
#    And user select a company package
#    And user experiences consistent brand aesthetics
#    And user enter Name on Card "<NameOnCard>", Card number "<CardNumber>", date "<Date>" and CVV "<Cvv>"
#    And user verify the my apps
#    Then user verify the child account
#    Examples:
#      | FirstName | LastName | MobileNumber | Password  | JobTitle | NMLSID | Address1 | Address2 | City     | ZipCode | State  | CompanyName | CompanyNMLSID | CompanyType | LoanOfficers | WebSiteURL                | NameOnCard | CardNumber       | Date  | Cvv |
#      | company   | test     | 5182610312   | Test@1234 | TestJob  | 123456 | USA      | UK       | New York | 10001   | Alaska | SMTP_Test   | 123456        | Retail      | 5            | https://cloud.taygo.tech/ | test       | 4242424242424242 | 01/28 | 123 |
##  Scenario: User on signup page
##    Given  user on the Signup page