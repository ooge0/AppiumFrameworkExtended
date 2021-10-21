import globalHelpers.CapabilitiesHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import runers.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utilities.SystemUtils.killAllNodes;

public class BookingAppTests_tc_1_Cloud extends Base {
    /*
    Test: Adding product to the shopping cart, checking link functionality by Gestures in the cart
     */
    @Test
    public static void bookingAppTests_tc_1() throws IOException, InterruptedException {
        AndroidDriver<AndroidElement> driver = CapabilitiesHelper.getCapabilities("BookingApp", true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
