package testNG.dataprovider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class GetDataWithMAP4POI {
	
	private static XSSFSheet objSheet;

	private static XSSFWorkbook objWorkbook;

	private static XSSFCell Cell;

	private static XSSFRow row;
	
	public static Map<String,Map<String,String>> readMultipleTestData(String sFilePath,String sSheetName,String sTestCaseName)throws Exception{


		Map<String,Map<String,String>> objTestData = new HashMap<String, Map<String,String>>();

		String sKey,sValue, sCurTestCaseName,sPreviousTestCaseName = "";
		int iRowNo = 1;
		XSSFWorkbook objWorkbook = new XSSFWorkbook(new File(sFilePath));
		XSSFSheet objSheet = objWorkbook.getSheet(sSheetName);
		//int iRowCount =  objSheet.getRows();
		//int iColCount =  objSheet.getColumns();
		row = objSheet.getRow(0);
		int iRowCount = objSheet.getLastRowNum();
		int iColCount = row.getLastCellNum();
		
		for(int iRowCounter=1;iRowCounter<iRowCount;iRowCounter++){

			Map<String,String> objRowData = new HashMap<String, String>();
			Cell = objSheet.getRow(iRowCounter).getCell(0);			
			sCurTestCaseName = Cell.getStringCellValue();			
			
			if ((sPreviousTestCaseName).length()!=0 && (sCurTestCaseName != sPreviousTestCaseName) && sTestCaseName.trim().length() > 0){
				break;
			}
			if ((sCurTestCaseName.equalsIgnoreCase(sTestCaseName)))
			{
				sPreviousTestCaseName = sCurTestCaseName;	

				for(int iColCounter = 1;iColCounter<iColCount;iColCounter++){
					sKey = objSheet.getRow(0).getCell(iColCounter).getStringCellValue();
					sKey = sKey.trim();
					sValue = objSheet.getRow(iRowCounter).getCell(iColCounter).getStringCellValue();;
					sValue = sValue.trim();
					System.out.println(sValue);
					if((!sValue.equalsIgnoreCase(null)) && (sValue.trim().length()!=0)){
						//System.out.println(sKey+sValue);
						objRowData.put(sKey,sValue);
					}
				}
				objTestData.put("Row" + iRowNo,objRowData);

				objRowData=null;

				iRowNo = iRowNo + 1;
			}
		}
		return objTestData;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		GetDataWithMAP4POI dm = new GetDataWithMAP4POI();
		
		dm.readMultipleTestData("C:\\TestData\\MingleShare1.xlsx","MingleShare","TC_01_MingleShareAndDrillback_VerifyGroupListShareAndDrillback");

	}

}
