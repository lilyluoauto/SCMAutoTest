package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * Created by w on 2015/12/21.
 */
public class MyEventListener extends AbstractWebDriverEventListener{
    @Override
    public void afterNavigateTo(String url,WebDriver driver){
        System.out.println("After Navigate To" + url);
    }
    @Override
    public void afterNavigateBack(WebDriver driver){
        System.out.println("After navigate Back To"+ driver.getCurrentUrl());
    }
    @Override
    public void afterClickOn(WebElement webElement,WebDriver driver){
        System.out.println("After Click on"+webElement.getText());
    }
}
