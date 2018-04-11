Feature: Scenarios based on API TC122363

  @BaseLine
  Scenario: 3rd party is not able to send data access clearance for VIN which doesn't exist

    Then I set the applicationID: "466b66c7-1abd-4346-a146-1c427d97d759"
    Given I request clearance with container ID: "X00S016A387GV" and VIN number: "WASWX7101EX7GB572"