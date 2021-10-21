package pageObjects.storeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement userNameField;
    @AndroidFindBy(xpath = "//*[@text ='Female']")
    public WebElement femaleGenderCheckBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement goToProductsCatalogButton;
    @AndroidFindBy(id = "android:id/text1")
    public WebElement countryDropdownMenu;

    public FormPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getNameField() {
        System.out.println("I'm login interaction with name field");
        return userNameField;
    }
}
