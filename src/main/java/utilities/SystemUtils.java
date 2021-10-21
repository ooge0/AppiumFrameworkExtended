package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemUtils {
    public AndroidDriver<AndroidElement> driver;

    public static void getMethodName() {
        String methodName = new Object() {
        }
                .getClass()
                .getEnclosingMethod()
                .getName();

        System.out.println("Current Method is " + methodName);
    }

    public static void showMeMessage(String message) {
        System.out.println("Test: " + message + " completed");
    }

    public static void killAllNodes() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(6000);
    }

    public static void startEmulator() throws IOException, InterruptedException {
        System.out.println("Starting appium emulator. user.dir: " + System.getProperty("user.dir"));
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\scripts\\startEmulator.bat");
        Thread.sleep(6000);
    }

    public static Properties getProperties() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\globalHelpers\\global.properties");
        Properties p = new Properties();
        p.load(fis);
        return p;
    }
}
