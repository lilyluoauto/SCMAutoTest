package appModules;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LogInPage;
import untils.Log;

import java.util.concurrent.TimeUnit;

//import org.yaml.snakeyaml.error.MarkedYAMLException;

public class ComOpe {
  private static WebDriver driver;
 // private String baseUrl;
  private boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();
  private static Log mylog=new Log(ComOpe.class.getName());
 
public static WebDriver setUp() throws Exception {
   // driver = new FirefoxDriver();

  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
  mylog.info("the current is " + Platform.getCurrent());
	driver= new ChromeDriver();
	//  baseUrl = "http://freemail.163.com/";
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    driver.get(untils.Constants.baseUrl);
    return driver;
  }


  public static void SignInAction(WebDriver d) throws Exception {
  //  driver.get(baseUrl + "/");
    LogInPage.getElement(d,LogInPage.userName).sendKeys(untils.Constants.sUsername);
    LogInPage.getElement(d,LogInPage.PwdInput).sendKeys(untils.Constants.sPwd);
    LogInPage.getElement(d, LogInPage.loginButton).click();
  }
  public static void SignInAction(WebDriver d ,String username, String passwd){
    LogInPage.getElement(d,LogInPage.userName).sendKeys(username);
    LogInPage.getElement(d,LogInPage.PwdInput).sendKeys(passwd);
    LogInPage.getElement(d, LogInPage.loginButton).click();
  }


public static void tearDown(WebDriver d) throws Exception {
    d.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
