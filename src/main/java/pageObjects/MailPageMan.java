package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by w on 2015/12/22.
 */
public class MailPageMan extends Page {
    WebDriver driver;
    public MailPageMan(String yamlFile, WebDriver driver) {
        super(yamlFile, driver);
    }
    public static String writeMailButton="writeMailButton";
    public static String receiveMailBox="receiveMailBox";

    public void enterPage(String expPage,int type){
        getElement(expPage,type).click();
        //	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }
}
