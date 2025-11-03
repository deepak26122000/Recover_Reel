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

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ExercisePage extends BaseClass {
    AppiumDriver driver;
    BaseClass baseClass = new BaseClass();
    Pointerinput pointerinput = new Pointerinput();
    Assertions assertions = new Assertions();
    ExplicitWait wait = new ExplicitWait(Hook.getDriver(), 50);

    public ExercisePage() {
        this.driver = Hook.getDriver();
    }

    private By profilePageElement = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)");
    private By libraryElement = AppiumBy.xpath("//android.widget.TextView[@text=\"Library\"]");
    private By plusElement = AppiumBy.androidUIAutomator("new UiSelector().text(\"\uE901\")");
    /*Exercise Element*/
    private By exeNameFieldElement = AppiumBy.xpath("//android.widget.EditText[@text=\"Exercise Name\"]");
    private By instructionElement = AppiumBy.xpath("//android.widget.EditText[@text=\"Instruction\"]");
    private By tagElement = AppiumBy.xpath("//android.widget.TextView[@text=\"+\"]");
    private By saveElement = AppiumBy.xpath("//android.widget.TextView[@text=\"Save\"]");
    private By enterNameErrorMsg = AppiumBy.xpath("//android.widget.TextView[@text=\"Exercise Name is required\"]");
    private By X_Element = AppiumBy.xpath("//android.widget.TextView[@text=\"\uE903\"]");
    private By tagSaveElement = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Save\"]");

    // Instructions list
    private List<String> instructionsList = List.of(
            "Ensure you maintain proper posture during this exercise.",
            "Start with slow movements and gradually increase speed.",
            "Perform each repetition with controlled breathing.",
            "Focus on your form rather than speed.",
            "Make sure to warm up before starting this exercise.",
            "If you feel pain, stop immediately and consult a professional.",
            "Perform this exercise for 3 sets of 10 repetitions.",
            "Keep your core engaged throughout the exercise."
    );


    private By tagList = AppiumBy.xpath("//android.widget.TextView[@text]");
    /*Create New Tag name Element*/
    private By createNewTagNameIconEle = AppiumBy.xpath("//android.widget.TextView[@text=\"\uE925\"]");
    private By newTagNameElement = AppiumBy.xpath("//android.widget.EditText[@text=\"Tag Name\"]");
    private By createTagNameSaveEle = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Save\"]");

    /*Folder Element*/
    private By folderEle = AppiumBy.xpath("//android.widget.TextView[@text=\"Folders\"]");
    private By folderPlusIcon = AppiumBy.xpath("//android.widget.TextView[@text=\"\uE901\"]");
    private By folderNameEle = AppiumBy.xpath("//android.widget.EditText[@text=\"Folder Name\"]");
    private By createNewFolderSave = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Save\"]");


    public void clickProfilePage() {
        baseClass.clickElement2(profilePageElement);
    }

    public void clickLibrary() {
        baseClass.clickElement2(libraryElement);
    }

    public void clickPlusIcon() {
        baseClass.clickElement2(plusElement);
    }

    public void enterExerciseName() {
        baseClass.clickElement(exeNameFieldElement);

        // Generate a random name using UUID
        String randomExerciseName = "Exercise_" + UUID.randomUUID().toString().substring(0, 6);

        // Enter the random name into the Exercise Name field
        baseClass.sendKeys(exeNameFieldElement, randomExerciseName);
        System.out.println(randomExerciseName + "Exercise created  ");
    }

    public void enterInstruction() {
        baseClass.clickElement(instructionElement);

        // Randomly select an instruction from the list
        String randomInstruction = getRandomInstruction();

        // Enter the randomly selected instruction
        baseClass.sendKeys(instructionElement, randomInstruction);
    }

    // Helper function to select a random instruction from the list
    private String getRandomInstruction() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(instructionsList.size());  // Random index from the list
        return instructionsList.get(randomIndex);  // Return the instruction at that index
    }

    public void clickTagIcon() {
        baseClass.clickElement(tagElement);
    }

    public void clickCreateNewTagNameIcon() {
        baseClass.clickElement(createNewTagNameIconEle);
    }


    public void selectRandomTagName() {
        List<WebElement> availableTags = driver.findElements(tagList);
        if (availableTags.isEmpty()) {
            System.out.println("No tags available to select ");
            return;
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(availableTags.size());
        WebElement selectedTag = availableTags.get(randomIndex);
        pointerinput.swipe();
        selectedTag.click();

    }

    public void tagSave() {
        baseClass.clickElement(tagSaveElement);
    }


    public void clickOnExeSaveButton() {
        baseClass.clickElement(saveElement);
    }

    public void exeErrorMsgValidation() {

        String expectedMsg = "Exercise Name is required";
        assertions.assertText(enterNameErrorMsg, expectedMsg);
        baseClass.clickElement2(X_Element);
    }

    public void X_Click() {
        baseClass.clickElement(X_Element);
    }

    /*Create New Tag name Methods*/

    public void createNewTagName() {
        baseClass.clickElement(newTagNameElement);
        // Generate a random tag name with @ at the start (you can adjust the length as needed)
        String randomTagName = "@" + UUID.randomUUID().toString().substring(0, 8);  // Tag name starts with @

        // Enter the new tag name into the input field
        baseClass.sendKeys(newTagNameElement, randomTagName);


        System.out.println("New tag created: " + randomTagName);
    }

    public void clickCreateNewTagNameSave() {
        baseClass.clickElement(createTagNameSaveEle);
        tagSave();
        X_Click();
    }

    /*Folder Methods */
    public void clickFolder(){
        baseClass.clickElement(folderEle);
    }
    public void clickFolderPlusIcon(){
        baseClass.clickElement(folderPlusIcon);
    }
    public void enterFolderName(){
        // Generate a random UUID and convert it into Upper Camel Case
        String randomFolderName = generateUpperCamelCase(UUID.randomUUID().toString().substring(0, 8));

        // Enter the folder name into the field
        baseClass.sendKeys(folderNameEle, randomFolderName);

        System.out.println("Folder Name Created with --> " + randomFolderName);
    }

    // Helper method to convert a string into Upper Camel Case
    private String generateUpperCamelCase(String input) {
        // Split the input into parts by non-alphanumeric characters (optional based on UUID format)
        String[] parts = input.split("(?<=\\G.{4})");

        // Capitalize each part and join them
        StringBuilder camelCaseString = new StringBuilder();
        for (String part : parts) {
            camelCaseString.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
        }

        return camelCaseString.toString();
    }

    public void clickSaveFolderBtn(){
        baseClass.clickElement(createNewFolderSave);
    }
}
