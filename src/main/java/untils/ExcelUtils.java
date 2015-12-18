package untils;

/**
 * Created by w on 2015/12/4.
 */

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    private static Sheet ExcelWSheet;

    private static Workbook ExcelWBook;

    private static org.apache.poi.ss.usermodel.Cell Cell;

    private static Row Row;
    private static Log log;

/*
    public static Object[] credentials() {

        return new Object[]{"testdata/userdata1.xls", "sheet1"};

    }

*/
    public static Sheet getExcelWSheet(String SheetName){
        int SheetNumber = 0;
        Sheet sheet=null;
        int i=0;
    //    Log.info("work book is "+ExcelWBook);
        SheetNumber=ExcelWBook.getNumberOfSheets();
        for(i=0;i<SheetNumber;i++) {
            //String name=null;
            String name=ExcelWBook.getSheetName(i);
            Log.info("sheet is " + name);


            if (name.equalsIgnoreCase(SheetName))
            {
                break;

             }
        }
    //    Reporter.log("index is " + index);
        if(i>=SheetNumber){
            return null;
        }else
         {
            sheet=ExcelWBook.getSheetAt(i);
        }
      return sheet;
    }
    public static Object[][] getTableArray(String FilePath, String SheetName,int SR,int SC) throws Exception {

        String[][] tabArray = null;
        log=new Log(ExcelUtils.class.getName());
        log.info(FilePath);

        try {
          //  String file=new File(FilePath).getAbsolutePath();
            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

//            ExcelWBook = create(ExcelFile);

  //          ExcelWSheet = getExcelWSheet(SheetName);
            setExcelFile(FilePath,SheetName);


            int startRow=SR;

            int startCol =SC;

            int ci,cj;

            int totalRows = ExcelWSheet.getLastRowNum();
            log.info("totalRows is "+totalRows);

            // you can write a function as well to get Column count

            int totalCols =ExcelWSheet.getPhysicalNumberOfRows();
            log.info("total cols is "+totalCols);

            tabArray=new String[totalRows][totalCols-1];

            ci=0;

            for (int i=startRow;i<=totalRows;i++, ci++) {

                cj=0;

                for (int j=startCol;j<totalCols;j++, cj++){

                    tabArray[ci][cj]=getCellData(i,j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e){

            log.info("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e){

           log.info("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        log=new Log(ExcelUtils.class.getName());

        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            int dataType = Cell.getCellType();

            if (dataType == 3) {

                return "";

            } else {

                String CellData = Cell.getStringCellValue();

                return CellData;

            }
        }catch(Exception e){

                log.info(e.getMessage());

                throw (e);

            }

    }
    public static void setCell(String FilePath,String sheetName,int RowNum,int ColNum,String result){
        log=new Log("setCell");

        try {
            ExcelUtils.setExcelFile(FilePath,sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Cell=ExcelWSheet.getRow(RowNum).createCell(ColNum);
        log.info("cell is "+Cell);
        Cell.setAsActiveCell();
        //   Cell.setCellType(1);
        Cell.setCellValue(result);
        log.info("set the result is "+result);
        /*    Label label = new Label(result);
            ExcelWSheet.setActiveCell(String.valueOf(label));
*/
        try {
            File excelFile=new File(FilePath);
            FileOutputStream fos=new FileOutputStream(excelFile);
            ExcelWBook.write(fos);
            ExcelWBook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void setExcelFile(String Path, String SheetName) throws Exception {
        Log log=new Log("setExcelFile");
        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);
/*
            File excelFile=new File(Path);
    //        log.info("excel file is" +excelFile.getAbsoluteFile());

            Log.info("excel file is "+excelFile.getName());
            String fileName=excelFile.getName();
            String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
            Log.info("fileName.lastIndexOf(\".\")+1 is"+ fileName.lastIndexOf(".")+1);
            Log.info("prefix is "+ prefix);
            if(prefix=="xls") {
                ExcelWBook = new HSSFWorkbook(inp);
                log.info("excel book is HSSF "+ExcelWBook);
            }
            else {
                ExcelWBook = new XSSFWorkbook(inp);
                log.info("excel book is XSSF  "+ ExcelWBook);
            }
*/
            ExcelWBook = create(ExcelFile);
         //   ExcelWBook=new XSSFWorkbook(OPCPackage.open(ExcelFile));
            log.info("excel book is "+ ExcelWBook.toString());

            ExcelWSheet = getExcelWSheet(SheetName);
            log.info("ExcelWSheet is "+ExcelWSheet);

        } catch (Exception e){

            throw (e);

        }


    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

    {

        String[][] tabArray = null;

        try{

       //     FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

 //           ExcelWBook = new XSSFWorkbook(ExcelFile);

 //           ExcelWSheet = ExcelWBook.getSheet(SheetName);

            setExcelFile(FilePath, SheetName);

            int startCol = 1;

            int ci=0,cj=0;

            int totalRows =ExcelWSheet.getLastRowNum();
            log.info("total rows is "+totalRows);

            int totalCols=ExcelWSheet.getPhysicalNumberOfRows();
            log.info("totalCols is "+totalCols);

            tabArray=new String[1][totalCols-1];

            for (int j=startCol;j<totalCols;j++)

            {

                tabArray[ci][cj]=getCellData(iTestCaseRow,j);

                System.out.println(tabArray[0][cj]);
                cj++;

            }

        }

        catch (FileNotFoundException e)

        {

            log.info("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e)

        {

            log.info("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    public static String getTestCaseName(String sTestCase)throws Exception{

        String value = sTestCase;

        try{

            int posi = value.indexOf("@");

            value = value.substring(0, posi);

            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);

            return value;

        }catch (Exception e){

            throw (e);

        }

    }
    public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

        int i;

        try {

            int rowCount = ExcelUtils.getRowUsed();
            log.info("rowCount="+rowCount);

            for ( i=0 ; i<=rowCount; i++){
                log.info("i="+i);
                if  (ExcelUtils.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

                    break;

                }

            }

            return i;

        }catch (Exception e){

            throw(e);

        }

    }

    public static int getRowUsed() throws Exception {

        try{

            int RowCount = ExcelWSheet.getLastRowNum();

            return RowCount;

        }catch (Exception e){

            System.out.println(e.getMessage());

            throw (e);

        }

    }

    public static Workbook create(InputStream inp) throws IOException,InvalidFormatException {
        if (!inp.markSupported()) {
            log.info("inp.markSupported="+(!inp.markSupported()));
            inp = new PushbackInputStream(inp, 8);
            log.info("inp is PushbackInputStream " +inp);
        }
        if (POIFSFileSystem.hasPOIFSHeader(inp)) {
            log.info("hssfworkbook" + POIFSFileSystem.hasPOIFSHeader(inp));
            return new HSSFWorkbook(inp);
        } else if (POIXMLDocument.hasOOXMLHeader(inp)) {
            log.info("xssfworkbook is "+POIXMLDocument.hasOOXMLHeader(inp));
            return new XSSFWorkbook(OPCPackage.open(inp));
        } else {
            throw new IllegalArgumentException("你的excel版本目前poi解析不了");
        }
    }


    public static void main(String arg0[]) {
        ExcelUtils excel = new ExcelUtils();
        String FilePath = "testdata/userdata.xlsx";
        String SheetName = "userdata1";
        /*
        try {
            getTableArray(FilePath, SheetName,1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            setExcelFile(FilePath,SheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // setCell(FilePath,SheetName,1,4,"pass");
    }

}

