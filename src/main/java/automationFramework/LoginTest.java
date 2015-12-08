package automationFramework;

import appModules.ComOpe;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import untils.Log;

public class LoginTest {
	private WebDriver driver;
	String name=LoginTest.class.getName();
	private Log mylog=new Log(LoginTest.class.getName());
	private String browser="chrome";
//	private Logger logger=Logger.getLogger(LoginTest.class.getName());
	
	
	@Test
  public void f() {
	  try {
		  mylog.info("sign in the web");
		ComOpe.SignInAction(driver);
        Reporter.log("Sign In Successful | " );
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	  try {
		  mylog.info("launch the website");
		  mylog.info(LoginTest.class.getName());
	//	  logger.info("launch !");
		driver=ComOpe.setUp(browser);
		Reporter.log("Launch the web site Successful | " );
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

  @AfterMethod
  public void afterMethod() {
	  try {
		ComOpe.tearDown(driver);
		Reporter.log("Logout the web site Successful | " );
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

}
