package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

/**
 * Created by w on 2015/12/23.
 */
public class seleGridTest {
    @Test
    public void f() {
        DesiredCapabilities firefoxCap = DesiredCapabilities.firefox();
        firefoxCap.setBrowserName("firefox");
        firefoxCap.setVersion("43.0.2");
        URL url=null;
        firefoxCap.setPlatform(Platform.extractFromSysProperty("Windows"));
        try {
            url=new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        WebDriver driver = new RemoteWebDriver(url,firefoxCap) {
            @Override
            public void get(String s) {

            }

            @Override
            public String getCurrentUrl() {
                return null;
            }

            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public String getPageSource() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public void quit() {

            }

            @Override
            public Set<String> getWindowHandles() {
                return null;
            }

            @Override
            public String getWindowHandle() {
                return null;
            }

            @Override
            public TargetLocator switchTo() {
                return null;
            }

            @Override
            public Navigation navigate() {
                return null;
            }

            @Override
            public Options manage() {
                return null;
            }
        };
        driver.get("http://freemail.163.com");



    }
}
