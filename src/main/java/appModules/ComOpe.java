package appModules;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
<<<<<<< HEAD
import pageObjects.Page;
=======
import pageObjects.LogInPage;
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
import untils.Log;

import java.util.concurrent.TimeUnit;

//import org.yaml.snakeyaml.error.MarkedYAMLException;

public class ComOpe {
  private static WebDriver driver;
 // private String baseUrl;
  private boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();
  private static Log mylog=new Log(ComOpe.class.getName());
<<<<<<< HEAD
  private static Page pg;
=======
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
 
public static WebDriver setUp(String browser) throws Exception {
   // driver = new FirefoxDriver();
  if(browser.equalsIgnoreCase("firefox")) {

    driver = new FirefoxDriver();

    // If browser is IE, then do this

  }else if (browser.equalsIgnoreCase("ie")) {

    // Here I am setting up the path for my IEDriver

    System.setProperty("webdriver.ie.driver", "D:\\project\\libs\\IEDriverServer.exe");

    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

    WebDriver driver = new InternetExplorerDriver(ieCapabilities);


  }else if (browser.equalsIgnoreCase("chrome")){
    //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
    System.setProperty("webdriver.chrome.driver","D:\\project\\libs\\chromedriver.exe");
    driver= new ChromeDriver();
  }


 // mylog.info("the current is " + Platform.getCurrent());

	//  baseUrl = "http://freemail.163.com/";
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    driver.get(untils.Constants.baseUrl);
    return driver;
  }


  public static void SignInAction(WebDriver d) throws Exception {
<<<<<<< HEAD
    //  driver.get(baseUrl + "/");
    pg=new Page("loginPage",d);
    pg.getElement(pg.userName,1).sendKeys(untils.Constants.sUsername);
    pg.getElement(pg.PwdInput,1).sendKeys(untils.Constants.sPwd);
    pg.getElement(pg.loginButton,1).click();
  }
/*
=======
  //  driver.get(baseUrl + "/");
    LogInPage.getElement(d,LogInPage.userName).sendKeys(untils.Constants.sUsername);
    LogInPage.getElement(d,LogInPage.PwdInput).sendKeys(untils.Constants.sPwd);
    LogInPage.getElement(d, LogInPage.loginButton).click();
  }
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
  public static void SignInAction(WebDriver d ,String username, String passwd){
    LogInPage.getElement(d,LogInPage.userName).sendKeys(username);
    LogInPage.getElement(d,LogInPage.PwdInput).sendKeys(passwd);
    LogInPage.getElement(d, LogInPage.loginButton).click();
  }
<<<<<<< HEAD
/*
  public static void SignInAction_loc(WebDriver d) throws Exception {
    //  driver.get(baseUrl + "/");
    LogInPage.getElement(d,LogInPage.userName).sendKeys(untils.Constants.sUsername);
    LogInPage.getElement(d,LogInPage.PwdInput).sendKeys(untils.Constants.sPwd);
    LogInPage.getElement(d, LogInPage.loginButton).click();
  }
*/
=======

>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c

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
