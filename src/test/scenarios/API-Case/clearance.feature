Feature: Testing api


  @InProgress
  Scenario: I try the requestClearance method
    Then I set the applicationID: "190b83f7-aca6-4515-919a-84a949323b1c"
    Given I request clearance with container ID: "S00P016R316KX" and VIN number: "WBY1Z4203EX7GB150"