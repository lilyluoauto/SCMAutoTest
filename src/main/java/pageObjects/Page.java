package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;


public class Page extends Locator {
	//WebDriver driver=null;
/*
	    public static By account=By.id("idPlaceholder");
	    public static By userName=By.id("idInput");
	    public static By PwdInput=By.id("pwdInput");
	    public static By loginButton=By.id("loginBtn");
*/
	public String account = "account";
	public String userName = "userName";
	public String PwdInput = "PwdInput";
	public String loginButton = "loginButton";
	public String freeLoginCheck = "freeLoginCheck";


	public Page(String yamlFile, WebDriver driver) {
		super(yamlFile, driver);
	}

	public static WebDriver SwitchWindow(WebDriver d, String expW) {
		String parWin = d.getWindowHandle();
		Set<String> WinHandles = d.getWindowHandles();
		for (String handle : WinHandles) {
			if (d.switchTo().window(handle).getTitle().contains(expW)) {
				d.switchTo().window(handle);
				break;
			}
		}
		return d;

	}

	public static void TakeScreenShot(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("screenShot/1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cookieWrite(WebDriver driver){
		File cookieFile=new File("testdata/freemail.cookie.txt");
		try{
			cookieFile.delete();
			cookieFile.createNewFile();
			FileWriter fileWriter=new FileWriter(cookieFile);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			for(Cookie cookie:driver.manage().getCookies()){
				bufferedWriter.write((cookie.getName()+";"+cookie.getValue()+";"+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getExpiry()+";"+cookie.isSecure()));
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enterPage(String expPage,int type){
		getElement(expPage,type).click();
	//	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
	public void enterIframe(WebElement e,WebDriver driver){

		driver.switchTo().frame(e);

	}
	public void goToDefault(WebDriver driver){
		driver.switchTo().defaultContent();
	}
}
	
