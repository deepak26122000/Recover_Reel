package Hooks;

import Utility.PropertiesClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Hook {

    private static AppiumDriver driver;
    private static final String APPIUM_SERVER_URL = PropertiesClass.getProperty("APPIUM_SERVER_URL");

    @BeforeAll
    public static void setUp() throws MalformedURLException, InterruptedException {

        String platform = PropertiesClass.getProperty("platform");
        DesiredCapabilities dc = new DesiredCapabilities();

        if (platform.equals("android")) {
            System.out.println(" Starting Appium session for ANDROID...");

            dc.setCapability("platformName", "Android");
            dc.setCapability("appium:automationName", "UiAutomator2");
            dc.setCapability("appium:autoGrantPermissions", true);
            dc.setCapability("appium:appPackage", "com.recoverreel.recoverreel");
            dc.setCapability("appium:appActivity", "com.recoverreel.recoverreel.MainActivityAppIcon");


            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), dc);

        } else if (platform.equals("ios")) {
            System.out.println(" Starting Appium session for iOS...");

            dc.setCapability("platformName", "iOS");
            dc.setCapability("appium:automationName", "XCUITest");
            dc.setCapability("appium:deviceName", "iPhone 15 Pro");
            dc.setCapability("appium:platformVersion", "17.0"); // Adjust to your simulator version
            dc.setCapability("appium:autoAcceptAlerts", true);

            // Change this to your iOS app’s bundle ID or .app path
            // Option 1: If app installed on simulator:
            dc.setCapability("appium:bundleId", "com.recoverreel.ios");
            // Option 2: If you have an app file:
            // dc.setCapability("appium:app", "/path/to/RecoverReel.app");

            driver = new IOSDriver(new URL(APPIUM_SERVER_URL), dc);

        } else {
            throw new IllegalArgumentException("Invalid platform specified. Use 'android' or 'ios'.");
        }

        Thread.sleep(2000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            System.out.println("Closing Appium session...");
            driver.quit();
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
