Feature: Scenarios based on API TC122335

  @BaseLine @ApiTest
  Scenario: 3rd party wants to request telematic data for specific container and VIN, but customer has revoked the data access clearance request

    Then I set the applicationID: "6db8511c-3ddf-4eac-bf92-9af463d3a2ce"
    Given I request telematic data with clearanceID: "831b4a00-90bc-4833-94a9-f84e79a8c984"



