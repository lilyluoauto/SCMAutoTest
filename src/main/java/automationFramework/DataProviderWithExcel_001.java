package automationFramework;

/**
 * Created by w on 2015/12/3.
 */

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import untils.ExcelUtils;
import untils.Log;

import static appModules.ComOpe.*;

public class DataProviderWithExcel_001 {

        private static WebDriver driver;
    private static String FilePath="testdata/userdata.xlsx";
    private static String sheetname="sheet1";
    private static Log log=new Log(DataProviderWithExcel_001.class.getName());
    private int iTestCaseRow;



     @DataProvider
/*
    public static Object[][] Authentication() {

       // return new Object[][] { {Constants.sUsername, Constants.sPwd }, { "luo.yongli", "lyl760502" }};
         Object[][] testObjArray = new Object[0][];
         try {
             testObjArray = ExcelUtils.getTableArray(FilePath,sheetname,1,1);
         } catch (Exception e) {
             e.printStackTrace();
         }
         log.info("data is "+testObjArray);
         return (testObjArray);


    }
    */
     public Object[][] Authentication() throws Exception{

         // Setting up the Test Data Excel file

         ExcelUtils.setExcelFile(FilePath, sheetname);

         String sTestCaseName = this.toString();
         log.info("test case name is "+sTestCaseName);

         // From above method we get long test case name including package and class name etc.

         // The below method will refine your test case name, exactly the name use have used

         sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
         log.info("test case name is "+sTestCaseName+"by getTestName!");

         // Fetching the Test Case row number from the Test Data Sheet

         // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

         iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);

         Object[][] testObjArray = ExcelUtils.getTableArray(FilePath,sheetname,iTestCaseRow);

         return (testObjArray);

     }


    @BeforeMethod
public void beforeMethod(){
    Reporter.log("launch the web site |");
    try {
        driver =setUp();
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    @Test(dataProvider = "Authentication")

      //  @Parameters({ "sUsername", "sPassword" })

        public void test(String sUsername, String sPassword) {


        Reporter.log("sign in web site|");
        SignInAction(driver, sUsername, sPassword);

    }
    @AfterMethod
        public void afterMethod(){
            try {
                Reporter.log("logout the web site!|");
                tearDown(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        }



