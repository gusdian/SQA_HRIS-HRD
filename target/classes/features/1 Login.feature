Feature: User Login to HRIS - PA HRD

  @LoginValid
  Scenario: Testing Login HRD Valid
    Given User mengakses url
    When User valid klik login button
    Then User berhasil login

  @LoginInvalid
  Scenario: Testing Login HRD Invalid
    When User invalid klik login button
    Then User gagal login
