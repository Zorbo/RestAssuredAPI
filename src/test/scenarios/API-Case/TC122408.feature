Feature: Scenarios based on API TC122408

  @BaseLine
  Scenario: Request Data Access Clearance for a light-mapped VIN

    Then I set the applicationID: "41b0b4c7-143d-4370-8d26-68d1bcce54e4"
    Given I request clearance with container ID: "G00F016K342GU" and VIN number: "WBY2Z2208EX7GB024"

