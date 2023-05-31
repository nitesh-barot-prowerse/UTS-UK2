Feature:  Verify Client Module Features


  Background:
    Given User should log in with username "sa" and password "Good2go@2019" to the admin panel
    When User clicks on client icon on left tool bar


  Scenario:Ensure that the Manage Client page displays list of client data after clicking on client icon on left tool bar
    Then Manage client page displays with list of clients

#  Scenario: To add and verify new client details inside client module
#    When User clicks on add client icon on manage client page
#    And User enters all mandatory details on add client page
#    And User clicks on create button on add client page
#    Then View client page appears with the details of currently added client
#
##  Scenario: Appropriate client data will display upon entering  code in search box
##    When User enters code number inside search box on manage client page
##    And User clicks on search button manage client page
##    Then Appropriate client information displays inside table on manage client page
#
#  Scenario: Check status of client
#    When User selects appropriate option from Active dropdown on manage client page
#    And User clicks on search button
#    And User clicks on client code on manage client page
#    Then Client status displays on view client page
#
##  Scenario: To check whether add quote page is displays for same user by clicking on add button on view client page
##    When User clicks on client code on manage client page
##    And User clicks on add button on view client page
##    Then Add quote page displays with same client code
#
#  Scenario:Verify add contact feature of client
#    When User clicks on client code on manage client page
#    And User selects Add contact option from setting dropdown besides of active text on view client page
#    And User enters all details inside add client window
#    Then Contact details can view under contacts menu on view client page


#  Scenario: Verify add notes feature of client
#    When User clicks on client code on manage client page
#    And User selects Add notes options from setting dropdown besides the active text on view client page
#    And User enters all details inside add notes window
#    Then Notes details can view under note menu tab on view client page
#
#  Scenario: Verify add task feature of client
#    When User clicks on client code on manage client page
#    And User selects Add task options from setting dropdown besides the active text on view client page
#    And User enters all details inside add task window
#    Then Task details can view under task menu tab on view client page
#
#  Scenario: To verify edit client functionality for existing client
#    When User clicks on client code on manage client page
#    And User selects edit client sections from setting dropdown besides the active text on view client page
#    And User enters all details of client on edit client window
#    Then Updated details can view on view client page
