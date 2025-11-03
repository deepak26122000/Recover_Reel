package StepDefinitions;

import PageObjectMoodels.TherapistSignUpPage;
import io.cucumber.java.en.*;

public class TherapistSignUpSteps {
    TherapistSignUpPage th = new TherapistSignUpPage();

    @Given("the therapist is on the Recovery Reel signup page")
    public void the_therapist_is_on_the_recovery_reel_signup_page() {

    }

    @When("the therapist clicks on the already have an account button")
    public void the_therapist_clicks_on_the_already_have_an_account_button() {
        th.clickAlreadyHaveButtonElement();
    }

    @And("Clicks on login as Therapist button")
    public void clicks_on_login_as_therapist_button() {
        th.clickTherapistButtonElement();
    }

    @And("the therapist navigates to the signIn page")
    public void the_therapist_navigates_to_the_sign_in_page() {
        String email="deepak@yopmail.com";
        th.enterEmailTextFieldElement(email);
    }

    @And("the therapist enters email address, password")
    public void the_therapist_enters_email_address_password() {
        String password="Deepak26122000@";
        th.enterPassword(password);
    }

    @Then("the therapist clicks login button")
    public void the_therapist_clicks_login_button() {
        th.clickLogInElement();
    }
}
