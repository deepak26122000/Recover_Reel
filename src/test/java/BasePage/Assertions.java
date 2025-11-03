package BasePage;

import Hooks.Hook;
import Utility.ExplicitWait;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Assertions {
ExplicitWait wait=new ExplicitWait(Hook.getDriver(),30);

    private AppiumDriver driver;

    public Assertions(){
        this.driver= Hook.getDriver();
    }

    // Method to assert that the text of an element matches the expected value
    public void assertText(By locator, String expectedText) {
        wait.visibilityOfElementLocated(locator);
        try {
            WebElement element = driver.findElement(locator);
            String actualText = element.getText().trim();
            Assert.assertEquals(actualText, expectedText, "Text mismatch. Expected: " + expectedText + ", Found: " + actualText);
        } catch (Exception e) {
            throw new AssertionError("Error in getting text from element: " + e.getMessage());
        }
    }
}
