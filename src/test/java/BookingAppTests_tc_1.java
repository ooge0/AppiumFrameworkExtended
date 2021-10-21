import globalHelpers.CapabilitiesHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.storeApp.CartPage;
import pageObjects.storeApp.FormPage;
import pageObjects.storeApp.ProductCatalogPage;
import runers.Base;
import utilities.Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utilities.SystemUtils.killAllNodes;

public class BookingAppTests_tc_1 extends Base {
    @BeforeTest
    public void beforeTests () throws IOException, InterruptedException {
        killAllNodes();
    }

    /*
    Test: Adding product to the shopping cart, checking link functionality by Gestures in the cart
     */
    @Test
    public static void bookingAppTests_tc_1() throws IOException, InterruptedException {
        AppiumDriverLocalService service = starAppiumServer();
        AndroidDriver<AndroidElement> driver = CapabilitiesHelper.getCapabilities("BookingApp", true);
        service.stop();
    }

}
