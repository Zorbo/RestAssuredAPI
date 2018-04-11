Feature: Scenarios based on API TC122323

  @BaseLine @ApiTest
  Scenario: 3rd party wants to request telematic data for specific container and VIN, customer has not answered the data access clearance request yet

    Then I set the applicationID: "190b83f7-aca6-4515-919a-84a949323b1c"
    Given I request telematic data with clearanceID: "99238c4a-7aac-4137-b69f-acae5bfc44be"