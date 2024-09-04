package tests;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    public static String projectRoot = System.getProperty("user.dir");
    private AppiumDriverLocalService service; // Appium server object
    @BeforeEach
    public void startServer(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }
    @AfterEach
    public void killServer(){
        if(service != null){
            service.stop();
        }
    }

    @Test
    public void serverTest(){
        String serviceUrl = service.getUrl().toString();
        System.out.println("serviceUrl = " + serviceUrl);
    }

    @Test
    public void testAndroidWikipedia() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(projectRoot+"/sample.apk")
                .setAppPackage("org.wikipedia")
                .setAppActivity("org.wikipedia.main.MainActivity");
        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL(service.getUrl().toString()), options
        );
        try {
            // driver.findElement(new AppiumBy.ByAccessibilityId("Wikipedia")).click();
            driver.getPageSource();
        } finally {
            driver.quit();
        }
    }
   @Test
   public void testIOS_Wikipedia() throws MalformedURLException {
       XCUITestOptions options = new XCUITestOptions();
       IOSDriver driver = new IOSDriver(
               // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
               new URL(service.getUrl().toString()), options
       );
       try {
           driver.findElement(new AppiumBy.ByAccessibilityId("Wikipedia")).click();
           driver.getPageSource();
       } finally {
           driver.quit();
       }
   }

}
