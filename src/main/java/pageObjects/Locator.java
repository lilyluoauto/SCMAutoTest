package pageObjects;

import appModules.ComOpe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import untils.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.ho.yaml.Yaml.loadType;
//import static org.yaml.snakeyaml.Yaml.*;

/**
 * Created by w on 2015/12/16.
 */
public class Locator {
    private String yamlFile;
    private static WebDriver driver;

    public Locator(String yamlFile,WebDriver driver){
        this.yamlFile=yamlFile;
        this.getYamlFile();
        this.driver=driver;
    }
    private static Map <String,Map<String,String>> ml;
    public void getYamlFile(){
        File f=new File("Locator/"+yamlFile+".yaml");
        try{
            ml= loadType(new FileInputStream(f.getAbsolutePath()), HashMap.class);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static By getBy(String type, String value){
        By by=null;
        if(type.equals("id")){
            by=By.id(value);
        }
        if(type.equals("name")){
            by=By.name((value));

        }
        if(type.equals("xpath")){
            by=By.xpath(value);
        }
        if (type.equals("className")) {
            by=By.className(value);
        }
        if(type.equals("linkText")){
            by=By.linkText(value);
        }
        if(type.equals("css")){
            by=By.cssSelector(value);
        }
        return by;
    }
    public static WebElement getElement(String k,int i) {
        String type = ml.get(k).get("type");
        String value = ml.get(k).get("value");
        By key = getBy(type, value);
        WebElement e=null;
        switch (i) {
                case 1:
                    e=driver.findElement(key);
                case 2:
                    e=getElementWithWait(key);
                case 3:
                    e=getClickableElement(key);
            }
        return e;

        }


    public static WebElement getElementWithWait(final By k) {
       // String type=ml.get(k).get("type");
       // String value=ml.get(k).get("value");
      //  final By key=getBy(type,value);
        ExpectedCondition<Boolean> ExpectedC=new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {

                return input.findElement(k).isDisplayed();

            }

        };
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean f = wait.until(ExpectedC);
        if (f) {
            return driver.findElement(k);
        } else {
            Log.info("element could not find!");
            return null;
        }
    }

    public static WebElement getClickableElement(By k){
       // String type=ml.get(k).get("type");
      //  String value=ml.get(k).get("value");
      //  By key=getBy(type,value);
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(k));
        return e;
    }


    public static void main(String arg0[]) throws Exception {
        WebDriver driver= ComOpe.setUp("chrome");
        Locator lo=new Locator("loginPage",driver);
        /*
     //   String account=lo.ml.get("account").toString();
     //   System.out.print("account is "+account+"\n");
        Iterator it=lo.ml.entrySet().iterator();
        while(it.hasNext()){
           Map.Entry entry=(Map.Entry)it.next();
           Object key=entry.getKey();
           Object value=entry.getValue();

           System.out.print("key is "+ key+"\n");
           System.out.print("Value is "+value+"\n");
            HashMap val=new HashMap((Map) value);
            String type=val.get("type").toString();
            System.out.print("type is "+type+"\n");
            String subVal=val.get("value").toString();
            System.out.print("value is "+subVal+"\n");
            /*
            Iterator subIt=val.entrySet().iterator();
            while(subIt.hasNext()){
                Map.Entry subEntry=(Map.Entry)subIt.next();
                Object subKey=subEntry.getKey();
                Object subVal1 =subEntry.getValue();
                System.out.print("subKey is "+subKey+"\n");
                System.out.print("subVal is "+subVal1+"\n");
            }

       }

*/
    }
}
