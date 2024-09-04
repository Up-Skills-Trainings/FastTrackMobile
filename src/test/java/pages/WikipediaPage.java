package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class WikipediaPage {

    public WikipediaPage(String platform){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(platform)),this);
    }

    // how to use same accessibility ID for both android and ios
    @iOSXCUITFindBy(accessibility = "Wikipedia")
    @AndroidFindBy(accessibility = "Wikipedia")
    public WebElement wikipedia;


}
