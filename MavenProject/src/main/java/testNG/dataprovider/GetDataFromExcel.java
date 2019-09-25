package testNG.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel {
	
	private static XSSFWorkbook excelbook;
	private static XSSFSheet excelsheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		 
	    try {
	 
	 // Open the Excel file
			 
			 FileInputStream ExcelFile = new FileInputStream(Path);
			 
			 // Access the required test data sheet
			 
			 excelbook = new XSSFWorkbook(ExcelFile);
			 
			 excelsheet = excelbook.getSheet(SheetName);
			 
	    	} catch (Exception e){
	 
	    			throw (e);
	 
	    	}
	 
	 }
	
	
	public static Object[][] getTestData(String xlPath,String sheet,int iTestCaseRow) throws IOException
	{
		 String[][] sTabArray = null;		 
		 FileInputStream fis = new FileInputStream(xlPath);
		 excelbook = new XSSFWorkbook(fis);
		 excelsheet = excelbook.getSheet(sheet);
		 
		 row = excelsheet.getRow(0);
		 
		 int startRow = 1;
		 int startColumn=1;		 
		 int ci=0;
		 int cj=0;
		
		 int rowcount = excelsheet.getLastRowNum();
		 int columncount = row.getLastCellNum();
		 
		 sTabArray = new String[rowcount][columncount];
		 for(int i=startColumn;i<=columncount;i++,cj++)
		 {
			 		 
			 sTabArray[ci][cj]= getData(iTestCaseRow,i);
			 
		 }		
		
		return sTabArray;
		
		
	}
	
	public static String getData(int rownum, int columnnum)
	{
		
		cell = excelsheet.getRow(rownum).getCell(columnnum);
		
		if(cell==null)
			return "";
		
		String celldata = cell.getStringCellValue();	
		
		return celldata;		
		
		
	}
	public static String getTestCaseName(String sTestCase)throws Exception
	{
		 
			 String value = sTestCase;
			 
			 try{
			 
				 int posi = value.indexOf("@");
				 
				 value = value.substring(0, posi);
				 
				 posi = value.lastIndexOf("."); 
				 
				 value = value.substring(posi + 1);
				 
				 return value;
			 
			 }
			 catch (Exception e){			 
			 throw (e);			 
			 }
		 
    }
		 
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
		 
		 int i;
		 
			 try {
			 
				 int rowCount = GetDataFromExcel.getRowUsed();
				 
				 for ( i=0 ; i<rowCount; i++){
				 
					 			if  (GetDataFromExcel.getData(i,colNum).equalsIgnoreCase(sTestCaseName)){
				 
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
		 
				 int RowCount = excelsheet.getLastRowNum();
				 
				 return RowCount;
			 
			 }
		 catch (Exception e){
			 
			 System.out.println(e.getMessage());
			 
			 throw (e);
			 
			 }
		 
		 }

}
