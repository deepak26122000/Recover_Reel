package BasePage;

import Hooks.Hook;
import Utility.ExplicitWait;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseClass {
    AppiumDriver driver;
    ExplicitWait wait = new ExplicitWait(Hook.getDriver(), 100);

    public BaseClass() {
        this.driver = Hook.getDriver();
    }

    public void clickElement(By element){
        wait.visibilityOfElementLocated(element);
        driver.findElement(element).click();
    }
    public void clickElement2(By element){
        wait.elementToBeClickable(element);
        driver.findElement(element).click();
    }

    public void sendKeys(By element ,String text){
        wait.visibilityOfElementLocated(element);
        WebElement el=driver.findElement(element);
        el.click();
        el.sendKeys(text);

    }
    public void sendKeys(By element ,int number){
        wait.visibilityOfElementLocated(element);
        WebElement el=driver.findElement(element);
        el.click();
        el.sendKeys(String.valueOf(number));

    }
    public String getText(By element){
        wait.visibilityOfElementLocated(element);
        return driver.findElement(element).getText();
    }

}
