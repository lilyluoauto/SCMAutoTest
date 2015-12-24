package pageObjects;

import org.openqa.selenium.WebDriver;

public class LogInPage extends Page{


	/*  login page element  */
	public String account = "account";
	public String userName = "userName";
	public String PwdInput = "PwdInput";
	public String loginButton = "loginButton";
	public String freeLoginCheck = "freeLoginCheck";

	public LogInPage(String yamlFile, WebDriver driver) {
		super(yamlFile, driver);
	}

	public void SignInAction(WebDriver d) throws Exception {

		//  driver.get(baseUrl + "/");
//		pg=new Page("loginPage",d);
		this.getElement(userName,1).sendKeys(untils.Constants.sUsername);
		this.getElement(PwdInput, 1).sendKeys(untils.Constants.sPwd);
		this.getElement(loginButton, 1).click();
	}

	public void SignInAction(WebDriver d, String username, String passwd){
		//pg=new Page("loginPage",d);
		getElement( userName,1).sendKeys(username);
		getElement(PwdInput,1).sendKeys(passwd);
		getElement(loginButton,1).click();
	}

}
	

