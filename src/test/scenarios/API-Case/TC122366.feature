Feature: Scenarios based on API TC122366

  @BaseLine
  Scenario: 3rd party is not able to send data access clearance for VIN from market, where OTP is not implemented

    Then I set the applicationID: "41b0b4c7-143d-4370-8d26-68d1bcce54e4"
    Given I request clearance with container ID: "G00F016K342GU" and VIN number: "WBY2Z2408EX7GB999"

