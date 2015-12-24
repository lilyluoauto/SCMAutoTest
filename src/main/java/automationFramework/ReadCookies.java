package automationFramework;

import appModules.ComOpe;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import untils.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by w on 2015/12/21.
 */
public class ReadCookies {
    private static BufferedReader bufferedReader;
    public static void main(String args0[]) throws Exception {
        Log log=new Log("main");
       WebDriver driver=null;
        driver= ComOpe.setUp("chrome");
        try {
            File cookieFile=new File("testdata/freemail.cookie.txt");
            String file= FileHandler.readAsString(cookieFile);
            log.info("file is "+ file);
            FileReader fileReader=new FileReader(cookieFile);
            bufferedReader=new BufferedReader(fileReader);
            String line;

            while((line=bufferedReader.readLine())!=null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
                Cookie cookie;
                cookie = null;
                while (stringTokenizer.hasMoreTokens()) {
                    String name = stringTokenizer.nextToken();
                    log.info("name is " + name);
                    String value = stringTokenizer.nextToken();
                    log.info("value is " + value);
                    String domain = stringTokenizer.nextToken();
                    log.info("domain is " + domain);
                    String path = stringTokenizer.nextToken();
                    log.info("path is " + path);
                    Date expiry = null;
                    String dt;
                    if (!(dt = stringTokenizer.nextToken()).equals("null")) {
                        log.info("dt is " + dt);
                        expiry = new Date(dt);
                        log.info(expiry.toString());

                    }
                    boolean isSecure = new Boolean(stringTokenizer.nextToken()).booleanValue();
                    cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    log.info("cookie is " + cookie);

                }
                driver.manage().addCookie(cookie);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
driver.findElement(By.id("loginBtn")).click();
//driver.get("http://freemail.163.com");
    }
}
