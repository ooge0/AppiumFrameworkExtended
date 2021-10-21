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

public class E_Commerce_tc_4 extends Base {
    @BeforeTest
    public void beforeTests () throws IOException, InterruptedException {
        killAllNodes();
    }

    /*
    Test: Adding product to the shopping cart, checking link functionality by Gestures in the cart
     */
    @Parameters({"name", "country", "totalAmountOfAddedProductsToTheCart"})
    @Test
    public static void totalValidation(String name, String country, int totalAmountOfAddedProductsToTheCart) throws IOException, InterruptedException {
        AppiumDriverLocalService service = starAppiumServer();
        AndroidDriver<AndroidElement> driver = CapabilitiesHelper.getCapabilities("StoreApp", false);

        FormPage formPage = new FormPage(driver);
        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        CartPage cartPage = new CartPage(driver);
        Utilities utilities = new Utilities(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 1. fill the nam field
        formPage.getNameField().sendKeys(name);
        driver.hideKeyboard();
        // 2. Select 'gender' option
        formPage.femaleGenderCheckBox.click();
        // 3. Open country dropdown and select country from the list. Don't scroll the list, just select from the countries that are presented in the screen
        formPage.countryDropdownMenu.click();
        utilities.scrollToCountryAndSelectIt(country);
        // 4. Proceed to the product catalog page
        formPage.goToProductsCatalogButton.click();
        // 5. Add to the cart desired amount of products
        addingItemsToTheCart(productCatalogPage, totalAmountOfAddedProductsToTheCart, driver);
        // 6. Opening the cart page by clicking the cart icon
        productCatalogPage.cartIcon.click();
        Thread.sleep(1000); // this is a required delay for the Appium because jumping from one page to another with the same locators can lead to the non-found elements
        //6.1 Get array of prices of ordered items
        int count = cartPage.itemPrices.size();
        // Count a sum of ordereeed items in the cart
        double sum = 0;
        for (int i = 0; i < count; i++) {
            String amountWithCurrency = cartPage.priceInCurrencyList.get(i).getText();
            sum = sum + getAmount(amountWithCurrency); // $160.97 + $120.0
        }
        String total = cartPage.totalAmountInTheCart.getText();
        System.out.println("Total sum is: " + sum);
        Assert.assertEquals(sum, Double.parseDouble(total.substring(2)));
        service.stop();
    }

    private static double getAmount(String amount1) {
        return Double.parseDouble(amount1.split("\\$")[1]);
    }

    private static void addingItemsToTheCart(ProductCatalogPage productCatalogPage, int totalAmountOfAddedProductsToTheCart, AndroidDriver<AndroidElement> driver) {
        for (int i = 0; i < totalAmountOfAddedProductsToTheCart; i++) {
            String text = productCatalogPage.products.get(i).getText();
            System.out.println("Desired product[" + i + "] name: " + text);
            productCatalogPage.addToCartButton.get(0).click();
        }
    }

}
