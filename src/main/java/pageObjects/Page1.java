package pageObjects;

import org.openqa.selenium.WebDriver;

public class Page1 extends Locator{

	public static String account="account";
	public static String userName="userName";
	public static String PwdInput="PwdInput";
	public static String loginButton="loginButton";

	public Page1(String yamlFile, WebDriver driver) {
		super(yamlFile, driver);
	}




	
}