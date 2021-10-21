package pageObjects.demoApiApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AppPreferencePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement PreferenceDependecies;

    public AppPreferencePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
