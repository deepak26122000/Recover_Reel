Feature: Exercise Functionality

  @signUp
  Scenario: Therapist signIn in with valid credentials
    Given the therapist is on the Recovery Reel signup page
    When the therapist clicks on the already have an account button
    And Clicks on login as Therapist button
    And the therapist navigates to the signIn page
    And the therapist enters email address, password
    Then the therapist clicks login button


  @exercise
  Scenario: Verify exercise with empty field
    Given the Therapist navigates to the Profile page
    When the Therapist clicks on the Library
    And clicks on the plus icon
    And leaves the Exercise name empty
    And clicks on the Save button
    Then the Therapist should get an error message

  @exercise
  Scenario: Create Exercise  with valid Credentials
    Given Click on the Plus button
    When Therapist enter valid name
    And Enter instructions
    And Select tag name
    And Clicks On Save Button
    Then Therapist get Success message

  @exercise
  Scenario: Verify Selecting Tag Name
    Given Again Click on Plus Button
    When Enter random exercise name
    And  Clicks on Tag
    Then Click save

  @exercise
  Scenario: Verify Creating New Tag Name inside Exercise
    Given Clicks to Plus Icon
    When The Therapist click on tagName Icon
    And Clicks on new TagName Icon
    And Enter Tag Name
    And Clicks on Create Tag name Save Button

  @exercise
    Scenario: Verify Folder Inside Exercise Entering Valid name
      Given Therapist Clicks on Folder
      Then Clicks on Folder plus icon
      And The Therapist enter Valid folder name
      And Clicks on folder  save button




