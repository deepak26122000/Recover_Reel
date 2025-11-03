package PageObjectMoodels;

import BasePage.BaseClass;
import Hooks.Hook;
import Utility.ExplicitWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TherapistSignUpPage extends BaseClass {
    AppiumDriver driver;
    ExplicitWait wait = new ExplicitWait(Hook.getDriver(), 100);
    BaseClass baseClass = new BaseClass();

    public TherapistSignUpPage() {
        driver = Hook.getDriver();
    }
    private By alreadyHaveButtonElement = AppiumBy.xpath("//android.widget.TextView[@text=\"Already have an account?\"]");
    private By therapistButtonElement = AppiumBy.xpath("//android.widget.TextView[@text=\"Login as Therapist\"]");
    private By emailTextFieldElement = AppiumBy.xpath("//android.widget.EditText[@text=\"Enter email address\"]");
    private By passwordTextFieldElement = AppiumBy.xpath("//android.widget.EditText[@text=\"Enter password\"]");
    private By logInElement = AppiumBy.accessibilityId("Log in");

    public void clickAlreadyHaveButtonElement() {
        baseClass.clickElement(alreadyHaveButtonElement);
    }

    public void clickTherapistButtonElement() {
        baseClass.clickElement(therapistButtonElement);
    }

    public void enterEmailTextFieldElement(String text) {
        baseClass.sendKeys(emailTextFieldElement, text);
    }

    public void enterPassword(String password) {

        baseClass.sendKeys(passwordTextFieldElement, password);
    }

    public void clickLogInElement() {
        baseClass.clickElement(logInElement);
    }


}
