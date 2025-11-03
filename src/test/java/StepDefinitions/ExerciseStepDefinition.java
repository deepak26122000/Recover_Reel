package StepDefinitions;

import PageObjectMoodels.ExercisePage;
import io.cucumber.java.en.*;

public class ExerciseStepDefinition {
    ExercisePage exercisePage = new ExercisePage();

    @Given("the Therapist navigates to the Profile page")
    public void the_therapist_navigates_to_the_profile_page() {
        exercisePage.clickProfilePage();
    }

    @When("the Therapist clicks on the Library")
    public void the_therapist_clicks_on_the_library() {
        exercisePage.clickLibrary();
    }

    @When("clicks on the plus icon")
    public void clicks_on_the_plus_icon() {
        exercisePage.clickPlusIcon();
    }

    @When("leaves the Exercise name empty")
    public void leaves_the_exercise_name_empty() {

    }

    @When("clicks on the Save button")
    public void clicks_on_the_save_button() {
        exercisePage.clickOnExeSaveButton();
    }

    @Then("the Therapist should get an error message")
    public void therapist_should_get_error_message() {
        exercisePage.exeErrorMsgValidation();
    }

    /*---------------------------------------------:  :---------------------------------------------------------*/
    @Given("Click on the Plus button")
    public void click_on_the_plus_button() {
        exercisePage.clickPlusIcon();
    }

    @When("Therapist enter valid name")
    public void therapist_enter_valid_name() {
        exercisePage.enterExerciseName();
    }

    @When("Enter instructions")
    public void enter_instructions() {
        exercisePage.enterInstruction();
    }

    @When("Select tag name")
    public void select_tag_name() {

    }

    @When("Clicks On Save Button")
    public void clicks_on_save_button() {
        exercisePage.clickOnExeSaveButton();
    }

    @Then("Therapist get Success message")
    public void therapist_get_success_message() {

    }

    /*---------------------------------------------:  :---------------------------------------------------------*/
    @Given("Again Click on Plus Button")
    public void again_click_on_plus_button() {
        exercisePage.clickPlusIcon();
    }

    @When("Enter random exercise name")
    public void enter_random_exercise_name() {
        exercisePage.enterExerciseName();
    }

    @When("Clicks on Tag")
    public void clicks_on_tag() {
        exercisePage.clickTagIcon();
        exercisePage.selectRandomTagName();
    }

    @Then("Click save")
    public void click_save() {
        exercisePage.tagSave();
        exercisePage.clickOnExeSaveButton();
    }

    /*---------------------------------------------:  :---------------------------------------------------------*/
    @Given("Clicks to Plus Icon")
    public void clicks_to_plus_icon() {
        exercisePage.clickPlusIcon();
    }

    @When("The Therapist click on tagName Icon")
    public void the_therapist_click_on_tag_name_icon() {
        exercisePage.clickTagIcon();
    }

    @When("Clicks on new TagName Icon")
    public void clicks_on_new_tag_name_icon() {
        exercisePage.clickCreateNewTagNameIcon();
    }

    @When("Enter Tag Name")
    public void enter_tag_name() {
        exercisePage.createNewTagName();
    }

    @When("Clicks on Create Tag name Save Button")
    public void clicks_on_create_tag_name_save_button() {
        exercisePage.clickCreateNewTagNameSave();
    }

    /*---------------------------------------------:  :---------------------------------------------------------*/
    @Given("Therapist Clicks on Folder")
    public void therapist_clicks_on_folder() {
        exercisePage.clickFolder();
    }

    @Then("Clicks on Folder plus icon")
    public void clicks_on_folder_plus_icon() {
        exercisePage.clickFolderPlusIcon();
    }

    @Then("The Therapist enter Valid folder name")
    public void the_therapist_enter_valid_folder_name() {
        exercisePage.enterFolderName();
    }

    @Then("Clicks on folder  save button")
    public void clicks_on_folder_save_button() {
        exercisePage.clickSaveFolderBtn();
    }
}
