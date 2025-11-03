package Utility;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {

    private WebDriverWait wait;
    public ExplicitWait(AppiumDriver driver ,int timeOutInSeconds){
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    }

    public  void visibilityOfElementLocated(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void elementToBeClickable(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
