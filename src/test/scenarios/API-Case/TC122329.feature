Feature: Scenarios based on API TC122329

  @BaseLine @ApiTest
  Scenario: 3rd party wants to request telematic data for specific container and VIN, but there are no data for the specified VIN yet

    Then I set the applicationID: "6db8511c-3ddf-4eac-bf92-9af463d3a2ce"
    Given I request telematic data with clearanceID: "21e7e275-5333-4865-818e-96912d5793dc"

