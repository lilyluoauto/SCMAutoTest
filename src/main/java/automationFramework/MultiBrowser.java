package automationFramework;

/**
 * Created by w on 2015/12/7.
 */

import appModules.ComOpe;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass

    // Passing Browser parameter from TestNG xml

    public void beforeTest(String browser) {

        try {
            driver=ComOpe.setUp(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Once Before method is completed, Test method will start

    @Test
    public void login() throws InterruptedException {

        try {
            ComOpe.SignInAction(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterTest() {

        driver.quit();

    }

}
