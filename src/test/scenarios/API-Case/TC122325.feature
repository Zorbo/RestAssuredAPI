Feature: Scenarios based on API TC122325

  @BaseLine @ApiTest
  Scenario: 3rd party wants to request telematic data for specific container and VIN, but customer has meanwhile performed reset of the OTP; Data access clearance was deleted

    Then I set the applicationID: "190b83f7-aca6-4515-919a-84a949323b1c"
    Given I request telematic data with clearanceID: "13619a68-2020-41e4-ae39-582a33b0d506"