# language: en
Feature: Work with Mail.Ru

  @emailComposeAndSendTest
  Scenario: Compose a new email and sent it

    Given browser is opened on login page

    When logged in with valid creds

    When compose new email form is opened
    And filled in To field with email "test@test.com"
    And filled in Email body with text "Lorem ipsum dolor sit amet"
    And clicked the Send Button
    Then Email sent successfully