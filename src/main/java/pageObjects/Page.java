package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;

public class Page{
	
	public static WebElement getElement(WebDriver d,By key){
		return d.findElement(key);
	}
	
}