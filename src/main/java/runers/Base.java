package runers;

import globalHelpers.CapabilitiesHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import static utilities.SystemUtils.startEmulator;


public class Base {
    public static AppiumDriverLocalService appiumService;
    public static AndroidDriver<AndroidElement> driver;

    public static AppiumDriverLocalService starAppiumServer() {
        boolean flag = checkIfAppiumServerIsRunning(4723);
        if (!flag) {
            appiumService = AppiumDriverLocalService.buildDefaultService();
            appiumService.start();
        }
        return appiumService;
    }

    public static boolean checkIfAppiumServerIsRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public static void getScreenshot(String testName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\defects_" + testName + ".png"));
    }

}
