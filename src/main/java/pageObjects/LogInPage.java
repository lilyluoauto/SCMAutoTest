package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends Page{
	

	    public static By account=By.id("idPlaceholder");
	    public static By userName=By.id("idInput");
	    public static By PwdInput=By.id("pwdInput");
	    public static By loginButton=By.id("loginBtn");
	    public void getButton(){}
	    
		public static WebElement getElement(WebDriver d, By key) {
			// TODO Auto-generated method stub
			return  d.findElement(key);
			
		}
}
	

