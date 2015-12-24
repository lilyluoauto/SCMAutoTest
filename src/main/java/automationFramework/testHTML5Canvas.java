package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by w on 2015/12/21.
 */
public class testHTML5Canvas {
    static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","D:\\project\\libs\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("http://literallycanvas.com");
    }

    @Test
    public void testHTML5Canvas() throws InterruptedException {

        WebElement canvas = driver.findElement(By.xpath("//*[@id='literally-canvas']/div[1]/div[1]/canvas[2]"));
        Thread.sleep(5*1000);
        Actions drawing=new Actions(driver);
        drawing.clickAndHold(canvas).moveByOffset(10, 100).moveByOffset(100, 10).moveByOffset(-10,-100).release().perform();
       // .moveByOffset(100,10).moveByOffset(-10,-500).moveByOffset(-500,-10).release().perform();
    }

    @AfterMethod
    public static void tearDown() throws Exception {
      //  driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }


}
