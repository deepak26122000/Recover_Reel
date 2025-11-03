Feature: Therapist Signup Functionality


  Scenario: Therapist signIn in with valid credentials
    Given the therapist is on the Recovery Reel signup page
    When the therapist clicks on the already have an account button
    And Clicks on login as Therapist button
    And the therapist navigates to the signIn page
    And the therapist enters email address, password
    Then the therapist clicks login button


  Scenario: Add multiple clients
    Given  Therapist clicks on Add New Client
    When The Therapist enter name,email,phoneNumber,Clicks on save

