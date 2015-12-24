package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by w on 2015/12/22.
 */
public class MailSendPage extends Page {
    public String receiveMailAddr="receiveMailAddr";
    public String mailTitle="mailTitle";
    public String mailEditIframe="mailEditIframe";
    public String mailContent="mailContent";
    public String sendMailBut="sendMailBut";
    public MailSendPage(String yamlFile, WebDriver driver) {
        super(yamlFile, driver);
    }

    public void sendMail(String sMailAddr, String mailAddr, String mailTitle, int type, WebDriver driver){
        getElement(receiveMailAddr,type).sendKeys(mailAddr);
        getElement(mailTitle,type).sendKeys(mailTitle);
        WebElement frame=getElement(mailEditIframe,type);
        enterIframe(frame,driver);
        getElement(mailContent,type).sendKeys("this is test");
        goToDefault(driver);
        getElement(sendMailBut,type).click();


    }


}
