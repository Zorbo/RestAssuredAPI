Feature: Scenarios based on API TC122368

  @BaseLine
  Scenario: 3rd party is not able to send data access request, when the T&C are not accepted and when the container doesn't belong to the 3rd party sending the request

    Then I set the applicationID: "41b0b4c7-143d-4370-8d26-68d1bcce54e4"
    Given I request clearance with container ID: "G00U016V324YT" and VIN number: "WBAWX710XEX7GB028"

