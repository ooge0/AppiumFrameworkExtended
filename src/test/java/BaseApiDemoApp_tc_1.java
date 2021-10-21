import globalHelpers.CapabilitiesHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.demoApiApp.AppHomePage;
import pageObjects.demoApiApp.AppPreferenceDependenciesPage;
import pageObjects.demoApiApp.AppPreferencePage;
import runers.Base;
import utilities.TestData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utilities.SystemUtils.killAllNodes;
import static utilities.Utilities.selectWiFicheckbox;

public class BaseApiDemoApp_tc_1 extends Base {
    @BeforeTest
    public void beforeTests () throws IOException, InterruptedException {
        killAllNodes();
        AppiumDriverLocalService service = starAppiumServer();
    }

    @Test(dataProvider = "InputData", dataProviderClass = TestData.class)
    public static void totalValidation(String input) throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = CapabilitiesHelper.getCapabilitiesForLocalRun( "ApiDemoApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        AppHomePage homePage = new AppHomePage(driver);
        AppPreferencePage appPreferencePage = new AppPreferencePage(driver);
        AppPreferenceDependenciesPage appPreferenceDependenciesPage = new AppPreferenceDependenciesPage(driver);

        homePage.Preference.click();
        appPreferencePage.PreferenceDependecies.click();
        selectWiFicheckbox(appPreferenceDependenciesPage);
        appPreferenceDependenciesPage.WiFiSettingsLink.click();
        appPreferenceDependenciesPage.WiFiInputField.sendKeys(input);
        appPreferenceDependenciesPage.WiFiSettingsOkButton.get(1).click();
    }
    @Test (dataProvider = "SingleData", dataProviderClass = TestData.class)
    public static void simpleTest(String input) throws IOException, InterruptedException {
        AppiumDriverLocalService service = starAppiumServer();
        AndroidDriver<AndroidElement> driver = CapabilitiesHelper.getCapabilitiesForLocalRun( "ApiDemoApp");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AppHomePage homePage = new AppHomePage(driver);
        homePage.Preference.click();
    }

    @AfterTest
    public void afterTests (){
        appiumService.stop();
    }

}