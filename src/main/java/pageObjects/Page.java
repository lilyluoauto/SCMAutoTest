package pageObjects;

import org.openqa.selenium.WebDriver;
<<<<<<< HEAD

public class Page extends Locator{
	
/*
	    public static By account=By.id("idPlaceholder");
	    public static By userName=By.id("idInput");
	    public static By PwdInput=By.id("pwdInput");
	    public static By loginButton=By.id("loginBtn");
*/

	public static String account="account";
	public static String userName="userName";
	public static String PwdInput="PwdInput";
	public static String loginButton="loginButton";

	public Page(String yamlFile, WebDriver driver) {
		super(yamlFile, driver);
	}
}
	

=======
import org.openqa.selenium.*;

public class Page{
	
	public static WebElement getElement(WebDriver d,By key){
		return d.findElement(key);
	}
	
}
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
