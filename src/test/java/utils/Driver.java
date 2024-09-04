package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    // singleton design, polymorphic (android and ios)
   private static AppiumDriver driver;
   private static AppiumDriverLocalService service;
   private static URL url;
   private static UiAutomator2Options capsA = new UiAutomator2Options();
   private static XCUITestOptions capsI = new XCUITestOptions();
   private Driver(){}

   public static AppiumDriver getDriver(String platform){
       if(Objects.isNull(driver)) {
           AppiumServiceBuilder builder = new AppiumServiceBuilder();
           builder.usingAnyFreePort();

           service = AppiumDriverLocalService.buildService(builder);
           service.start();
           switch (platform) {
               case "android":
                   try {
                       url = new URL(service.getUrl().toString());
                   } catch (MalformedURLException e) {
                       throw new RuntimeException(e);
                   }
                   driver = new AndroidDriver(url, capsA);
                   break;
               case "ios":
                   try {
                       url = new URL(service.getUrl().toString());
                   } catch (MalformedURLException e) {
                       throw new RuntimeException(e);
                   }
                   driver = new IOSDriver(url, capsI);
                   break;
           }
       }
       return driver;
   }
   public static void closeDriver(){
       if(Objects.nonNull(driver)){
           driver.quit();
           driver = null;
       }
       if(service != null){
           service.stop();
       }
   }
}
