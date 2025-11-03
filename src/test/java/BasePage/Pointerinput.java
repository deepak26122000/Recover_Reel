package BasePage;

import Hooks.Hook;
import Utility.ExplicitWait;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class Pointerinput {
    AppiumDriver driver;
    ExplicitWait wait = new ExplicitWait(Hook.getDriver(), 30);

    public Pointerinput() {
        this.driver = Hook.getDriver();
    }

    public void swipe() {
        int startX = 500;
        int startY = 1000;
        int endX =200;
        int endY=200;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800),PointerInput.Origin.viewport(),endX,endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(swipe));

    }
    public void tap(By element){
        WebElement el = driver.findElement(element);  // convert By to WebElement
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(el), 0, 0));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(tap));
    }


}
