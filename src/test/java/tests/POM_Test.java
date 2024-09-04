package tests;

import org.junit.jupiter.api.Test;
import pages.WikipediaPage;
import utils.Driver;

public class POM_Test {
    WikipediaPage wikipediaPage;
    @Test
    public void androidPOM_test(){
        wikipediaPage = new WikipediaPage("android");
        wikipediaPage.wikipedia.click();
        Driver.closeDriver();
    }

    @Test
    public void iosPOM_test(){
        wikipediaPage = new WikipediaPage("ios");
        wikipediaPage.wikipedia.click();
        Driver.closeDriver();
    }

}
