Feature: Scenarios based on API TC122332

  @BaseLine @ApiTest
  Scenario: 3rd party wants to request telematic data for specific container and VIN, but customer has rejected the data access clearance request

    Then I set the applicationID: "6db8511c-3ddf-4eac-bf92-9af463d3a2ce"
    Given I request telematic data with clearanceID: "4e3691f3-9d4e-4e71-aca3-6fa725462585"