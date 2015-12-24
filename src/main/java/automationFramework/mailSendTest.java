package automationFramework;

import appModules.ComOpe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MailPageMan;
import pageObjects.MailSendPage;
import untils.Constants;
import untils.Log;

/**
 * Created by w on 2015/12/22.
 */
public class mailSendTest  {
    private WebDriver d=null;
    private String yamlFile="Locator";
    private String browser="chrome";
    int type=1;

    private String mailTitle="this is test";
    private String mailContents="testing sending mail";
    private Log log=new Log(mailSendTest.class.getName());


    @BeforeMethod

    public void beforeMethod() {
        try {
            d = ComOpe.setUp(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogInPage lpg = new LogInPage(yamlFile,d);
        try {
            lpg.SignInAction(d);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

 @Test
         public void f(){
     MailPageMan mpm=new MailPageMan(yamlFile,d);
     log.info("element is "+ d.findElement(By.xpath("//*[@id='_mail_component_61_61']/span[2]")));
     mpm.enterPage(mpm.writeMailButton, type);
     MailSendPage msp=new MailSendPage(yamlFile,d);
     msp.sendMail(Constants.sMailAddr,mailTitle,mailContents,type,d);

 }


   @AfterMethod
   public void afterMethod() {
       try {
   //        ComOpe.tearDown(d);
           Reporter.log("Logout the web site Successful | ");

       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }

}
