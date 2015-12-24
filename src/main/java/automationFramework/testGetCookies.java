package automationFramework;

import appModules.ComOpe;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageObjects.Page;
import untils.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by w on 2015/12/21.
 */
public class testGetCookies {
    public static void main(String args0[]) throws Exception {
        WebDriver driver=null;
        driver= ComOpe.setUp("chrome");
        Page pg=new Page("loginPage",driver);
        pg.getElement(pg.userName, 1).clear();
        pg.getElement(pg.userName, 1).sendKeys(Constants.sUsername);
        pg.getElement(pg.PwdInput,1).clear();
        pg.getElement(pg.PwdInput,1).sendKeys(Constants.sPwd);
        //System.out.print("check e is "+ driver.findElement(By.xpath("//*[@id='lfAutoLogin']/b")));
        if(!pg.getElement(pg.freeLoginCheck,1).isSelected()){
            pg.getElement(pg.freeLoginCheck,1).click();
        }

        pg.getElement(pg.loginButton, 1).click();
        /*
        if(!driver.findElement(By.className("remember-me")).isSelected()){
            driver.findElement(By.className("remember-me")).click();

        }
        driver.findElement(By.className("sign-button submit")).click();
        */
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
        driver.quit();
    }
}
