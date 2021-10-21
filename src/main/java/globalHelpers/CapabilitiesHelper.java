package globalHelpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import runers.Base;
import utilities.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class CapabilitiesHelper {
    public static AndroidDriver<AndroidElement> getCapabilities(String appName, boolean cloudFlag) throws IOException, InterruptedException {
        if (cloudFlag) {
            return getCapabilitiesForCloud(appName);
        } else {
            return getCapabilitiesForLocalRun(appName);
        }
    }

    public static AndroidDriver<AndroidElement> getCapabilitiesForLocalRun(String appName) throws IOException {
        Properties p = SystemUtils.getProperties();
        String devicePlatformName = (String) p.get("devicePlatformName");
        String deviceName = (String) p.get("deviceName");
        String avdName = (String) p.get("avdName"); // comment this parameter and use String avdName = System.getProperty("avdName"); for executing the tests by Maven / Jenkins
        String mobileCapabilityType = (String) p.get("mobileCapabilityType");
        String deviceOsVersion = (String) p.get("deviceOsVersion");
        int appiumCommandTimeout = Integer.parseInt((String) p.get("appiumCommandTimeout"));
        String appiumServerUrl = (String) p.get("appiumServerUrl");
        File appDir = new File(System.getProperty("user.dir") + "\\src\\main\\apkSources");
        File appFile = new File(appDir, (String) p.get(appName));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd", avdName);
        capabilities.setCapability(MobileCapabilityType.VERSION, deviceOsVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, devicePlatformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //<< for defined devices, when you know the name of devices
        capabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, mobileCapabilityType);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, appiumCommandTimeout);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("fullReset", false);
        return new AndroidDriver<AndroidElement>(new URL(appiumServerUrl), capabilities);
    }

    public static AndroidDriver<AndroidElement> getCapabilitiesForCloud(String appName) throws IOException, InterruptedException {
        Properties p = SystemUtils.getProperties();
        String mobileCapabilityType = (String) p.get("mobileCapabilityType");
        String browserstackUserId = (String) p.get("browserstackUserId");
        String browserstackKey = (String) p.get("browserstackKey");
        String browserStackAppUrl = (String) p.get("browserStack"+ appName+ "Url");
        int appiumCommandTimeout = Integer.parseInt((String) p.get("appiumCommandTimeout"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set your access credentials
        capabilities.setCapability("browserstack.user", browserstackUserId);
        capabilities.setCapability("browserstack.key", browserstackKey);
        // Set URL of the application under test
        if (appName.contains("ApiDemoApp")) {
            capabilities.setCapability("app", "bs://f7198c1c2e07fde3cdca86e95ef828eedad228de");
//            capabilities.setCapability("app", browserStackAppUrl);
        }
        else if (appName.contains(("StoreApp"))){
            capabilities.setCapability("app", "bs://e49ce5121861d083db516cd1d5d0363c2db2557b");
//            capabilities.setCapability("app", browserStackAppUrl);
        }
        else if (appName.contains(("BookingApp"))){
            capabilities.setCapability("app", "bs://04ebb26e61fecf62c331f2b6b5d68b5d84046bd7");
//            capabilities.setCapability("app", browserStackAppUrl);
        }
        // Specify device and os_version for testing
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        // Set additional Appium configurations
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, mobileCapabilityType);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, appiumCommandTimeout);
        Base.driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
        return Base.driver;
    }

    public static AndroidDriver<AndroidElement> capabilitiesConfiguratorForWeb(String avdName, String devicePlatformName, String realDeviceName, String deviceName, String mobileCapabilityType, String osVersion, int appiumCommandTimeout, String url, String browserName) throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        if (avdName.equals("emulator")) {
            cap.setCapability(MobileCapabilityType.VERSION, osVersion);
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, devicePlatformName);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); //<< for defined devices. when you know the name of devices
            System.out.println("*************** EMULATOR!!!");
        } else if (avdName.equals("real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, realDeviceName); //<< for any connected devices in the system. ADB can recognise android device and use its name by default.
            System.out.println("*************** REAL!!!");
        }
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, mobileCapabilityType);
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, appiumCommandTimeout);
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("fullReset", false);
        return new AndroidDriver<AndroidElement>(new URL(url), cap);
    }
}
