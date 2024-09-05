package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("This is coming from HOOKS setup");
       // Driver.getDriver("android");
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
