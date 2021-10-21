package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObjects.demoApiApp.AppPreferenceDependenciesPage;
import pageObjects.storeApp.FormPage;

public class Utilities {
    AndroidDriver<AndroidElement> driver;

    public Utilities(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public static void scrollMethod_1(AndroidDriver<AndroidElement> driver, WebElement element) {
        // Initialize Javascript executor
        JavascriptExecutor js = driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollMethod_2(JavascriptExecutor driver) throws InterruptedException {
        JavascriptExecutor jse = driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(2000);
    }

    public static String getChecked(AppPreferenceDependenciesPage appPreferenceDependenciesPage) {
        return appPreferenceDependenciesPage.PreferenceDependecyCheckBox.getAttribute("checked");
    }

    public static void selectWiFicheckbox(AppPreferenceDependenciesPage appPreferenceDependenciesPage) {
        boolean checkBoxSelected = Boolean.parseBoolean(getChecked(appPreferenceDependenciesPage));
        if (!checkBoxSelected){
            appPreferenceDependenciesPage.PreferenceDependecyCheckBox.click();
        }
    }

    public void scrollToCountryAndSelectIt(String countryName) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + countryName + "\"));");
        driver.findElement(By.xpath("//*[@text ='" + countryName + "']")).click();

    }
}
