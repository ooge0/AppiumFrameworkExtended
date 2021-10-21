//package runers;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import static globalHelpers.AppiumServerHelper.checkIfServerIsRunning;
//import static globalHelpers.AppiumServerHelper.startEmulator;
//import static globalHelpers.CapabilitiesHelper.capabilitiesConfigurator;
//
//public class BaseRunner_old {
//
//    public static AndroidDriver<AndroidElement> capabilities(String device, String appFileName) throws IOException, InterruptedException {
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\globalHelpers\\global.properties");
//        Properties p = new Properties();
//        p.load(fis);
//
//        String devicePlatformName = (String) p.get("devicePlatformName");
//        String realDeviceName = (String) p.get("realDeviceName");
//        String emulatorName = (String) p.get("emulatorName");
//        String mobileCapabilityType = (String) p.get("mobileCapabilityType"); //"Uiautomator2";
//        String deviceOsVersion = (String) p.get("deviceOsVersion");
//        int appiumCommandTimeout = Integer.parseInt((String) p.get("appiumCommandTimeout"));
//        String appiumServerUrl = (String) p.get("appiumServerUrl");
//        int appiumServerPort = Integer.parseInt((String) p.get("appiumServerPort"));
//        File appDir = new File(System.getProperty("user.dir") + "\\src\\main\\apkSources");
//        File appFile = new File(appDir, (String) p.get(appFileName));
//
//        checkIfServerIsRunning(appiumServerPort);
////        startAppiumServer();
//        startEmulator();
//        return capabilitiesConfigurator(device, devicePlatformName, realDeviceName, emulatorName, mobileCapabilityType, deviceOsVersion, appiumCommandTimeout, appiumServerUrl, appFile);
//    }
//
////    stopEmulator();
//}
