Feature: Scenarios based on API TC122361

  @BaseLine
  Scenario: 3rd party is not able to send data access clearance for container ID, which does not exist

    Then I set the applicationID: "41b0b4c7-143d-4370-8d26-68d1bcce54e4"
    Given I request clearance with container ID: "G00F016K342GX" and VIN number: "WBY2Z2408EX7GB571"

