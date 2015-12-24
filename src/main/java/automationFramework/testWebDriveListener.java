package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by w on 2015/12/21.
 */
public class testWebDriveListener {
    public static void main(String args0[]) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
        MyEventListener myEventListener=new MyEventListener();
        eventFiringDriver.register(myEventListener);
        eventFiringDriver.get("http://www.baidu.com");
        Thread.sleep(5*1000);
        eventFiringDriver.get("http://freemail.163.com");
        Thread.sleep(20*1000);
        eventFiringDriver.navigate().back();
        Thread.sleep(10*1000);
        eventFiringDriver.findElement(By.id("kw")).sendKeys("selenium");
        System.out.print("text of element is " + driver.findElement(By.id("su")).getAttribute("value"));
        eventFiringDriver.findElement(By.id("su")).click();
    }
}
