package pageObjects.demoApiApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppPreferenceDependenciesPage {
    @AndroidFindBy(id = "android:id/checkbox")
    public WebElement PreferenceDependecyCheckBox;

    @AndroidFindBy(xpath= "(//android.widget.RelativeLayout)[2]")
    public WebElement WiFiSettingsLink;

    @AndroidFindBy(className= "android.widget.EditText")
    public WebElement WiFiInputField;

    @AndroidFindBy(className= "android.widget.Button")
    public List<WebElement> WiFiSettingsOkButton;

    public AppPreferenceDependenciesPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
