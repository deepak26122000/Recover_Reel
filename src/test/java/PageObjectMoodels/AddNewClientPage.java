package PageObjectMoodels;

import BasePage.Assertions;
import BasePage.BaseClass;
import BasePage.Pointerinput;
import Hooks.Hook;
import Utility.ExplicitWait;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddNewClientPage extends BaseClass {
    AppiumDriver driver;
    ExplicitWait wait = new ExplicitWait(Hook.getDriver(), 30);
    BaseClass baseClass = new BaseClass();
    Pointerinput pointerInput=new Pointerinput();

    public AddNewClientPage(){
        this.driver=Hook.getDriver();
    }


    /*Elements*/
    private By addNewClientElement= AppiumBy.xpath("//android.widget.TextView[@text=\"Add New Client\"]");
    private By clientNameElement=AppiumBy.xpath("//android.widget.EditText[@text=\"Name\"]");
    private By clientEmailElement=AppiumBy.xpath("//android.widget.EditText[@text=\"Enter email address\"]");
    private By clientPhoneNumberElement=AppiumBy.xpath("//android.widget.EditText[@text=\"Phone\"]");

    /*Groups*/
    private By clientGroupElement=AppiumBy.androidUIAutomator("new UiSelector().text(\"Group\")");
    private By groupNameElements=AppiumBy.className("android.view.ViewGroup");
    private By groupsSaveElement=AppiumBy.xpath("//android.widget.TextView[@text=\"Save\"]");

    private By clientSaveElement=AppiumBy.accessibilityId("Save");

    /*Methods*/
    public void clickOnAddClient(){
        baseClass.clickElement(addNewClientElement);
    }
    public void enterClientName(String userName){
        baseClass.clickElement2(clientNameElement);
        baseClass.sendKeys(clientNameElement,userName);
    }
    public void enterClientEmail(String email){
        baseClass.clickElement(clientEmailElement);
        baseClass.sendKeys(clientEmailElement,email);
    }
    public void enterPhoneNumber(String PhoneNumber){
        baseClass.clickElement(clientPhoneNumberElement);
        baseClass.sendKeys(clientPhoneNumberElement,PhoneNumber);
    }
 /*   public void clickOnGroups(){
        baseClass.clickElement(clientGroupElement);
        List<WebElement> groups = driver.findElements(groupNameElements);
        if (groups.size() > 1) {
            // Select a random group
            int randomIndex = new Random().nextInt(groups.size());
            groups.get(randomIndex).click();
        } else {
            System.out.println("Group list not available");
        }
        baseClass.clickElement(groupsSaveElement);

    }*/
    public void clickOnSave() throws InterruptedException {
        System.out.println("Marker is on swipe");
        pointerInput.swipe();
        Thread.sleep(4000);
        System.out.println("Is Save displayed? " + driver.findElement(clientSaveElement).isDisplayed());
        System.out.println("Save button location: " + driver.findElement(clientSaveElement).getRect());
        Thread.sleep(10000);
       pointerInput.tap(clientSaveElement);

    }
    public void homePageValidation() throws InterruptedException {
        System.out.println(" ready to Navigate to the home page");
        Thread.sleep(3000);
            String text = driver.findElement(addNewClientElement).getText().trim();
            Assert.assertFalse(text.isEmpty(), "Therapist did not navigate to home page.");
        }



    }
