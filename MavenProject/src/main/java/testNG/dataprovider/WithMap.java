package testNG.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class WithMap {
	
	private static XSSFWorkbook excelbook;
	private static XSSFSheet excelsheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	
	public static void getTestData(String xlPath,String sheet) throws IOException
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
		 
		 String sKey = null;
		 String sValue = null;
		
		 int rowcount = excelsheet.getLastRowNum();
		 int columncount = row.getLastCellNum();
		 
		 HashMap<String, String> objMap = new HashMap<String, String>();	
		 
		 for(int i=1;i<=rowcount;i++)
		 {
			 for(int j=1;j<=columncount;j++)
			 {
			 sKey = getData(0,j);
			 sValue = getData(i,j);
			 
			 objMap.put(sKey, sValue);			 
		      }
		 }
		 System.out.println(objMap);
		
		 
	}
	public static String getData(int rownum, int columnnum)
	{
		
		cell = excelsheet.getRow(rownum).getCell(columnnum);
		
		if(cell==null)
			return "";
		
		String celldata = cell.getStringCellValue();	
		
		return celldata;		
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		
		WithMap m= new WithMap();
		
		m.getTestData("C:\\JavaWorkSpace\\MavenProject\\src\\main\\java\\testNG\\dataprovider\\testData\\TestData.xlsx","Login");
		
		
	}

}
