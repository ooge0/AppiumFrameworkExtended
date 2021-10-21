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

//    public static AndroidDriver<AndroidElement>  getConfiguredCapabilities(String appFileName) throws IOException {
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\globalHelpers\\global.properties");
//        Properties p = new Properties();
//        p.load(fis);
//
//        String devicePlatformName = (String) p.get("devicePlatformName");
//        String deviceName = (String) p.get("deviceName");
//        String avdName = (String) p.get("avdName");
//        String mobileCapabilityType = (String) p.get("mobileCapabilityType"); //"Uiautomator2";
//        String deviceOsVersion = (String) p.get("deviceOsVersion");
//        int appiumCommandTimeout = Integer.parseInt((String) p.get("appiumCommandTimeout"));
//        String appiumServerUrl = (String) p.get("appiumServerUrl");
////        int appiumServerPort = Integer.parseInt((String) p.get("appiumServerPort"));
//        File appDir = new File(System.getProperty("user.dir") + "\\src\\main\\apkSources");
//        File appFile = new File(appDir, (String) p.get(appFileName));
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("avd", avdName);
//        capabilities.setCapability(MobileCapabilityType.VERSION, deviceOsVersion);
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, devicePlatformName);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //<< for defined devices, when you know the name of devices
//        capabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, mobileCapabilityType);
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, appiumCommandTimeout);
//        capabilities.setCapability("autoGrantPermissions", true);
//        capabilities.setCapability("fullReset", false);
//        driver = new AndroidDriver<AndroidElement>(new URL(appiumServerUrl), capabilities);
//        return driver;
//    }
}
